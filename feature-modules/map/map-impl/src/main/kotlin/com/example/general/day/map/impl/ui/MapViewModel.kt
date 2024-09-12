package com.example.general.day.map.impl.ui

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.ui.core.R
import com.example.general.day.map.impl.di.MapFeatureDependencies
import com.example.general.day.ui.components.helpers.WeatherDataConverter
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.core.utils.ZoneClusterManager
import com.example.general.day.ui.core.utils.ZoneClusterManagerFactory
import com.example.general.day.ui.core.utils.calculateCameraViewPoints
import com.example.general.day.ui.core.utils.getCenterOfPolygon
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import kotlin.coroutines.cancellation.CancellationException

private const val PROVIDER_NAME = "provider_name"

class MapViewModel @Inject constructor(
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val dependencies: MapFeatureDependencies,
    private val weatherDataConverter: WeatherDataConverter,
    private val sharedPreferences: SharedPrefManager,
    private val zoneClusterManagerFactory: ZoneClusterManagerFactory,
    private val toastNotificationManger: ToastNotificationManger,
    private val currentWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val fetchWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MapState())
    val state: StateFlow<MapState> = _uiState.asStateFlow()

    init {
        val cityName = sharedPreferences.getSavedCityName().orEmpty()
        _uiState.update { it.copy(cityName = cityName) }
    }

    fun getWeatherForLocation(location: LatLng) {
        val latitude = location.latitude
        val longitude = location.longitude

        val lastKnownLocation = Location(PROVIDER_NAME).apply {
            this.latitude = latitude
            this.longitude = longitude
        }

        viewModelScope.launch {
            try {
                val currentWeatherDeferred = async {
                    fetchWeatherUseCase.fetchCurrentWeather(latitude, longitude)
                }

                val weatherForFiveDaysDeferred = async {
                    fetchWeatherUseCase.fetchWeatherForFiveDays(latitude, longitude)
                }

                val awaitCurrentWeather = currentWeatherDeferred.await()
                val awaitWeatherForFiveDays = weatherForFiveDaysDeferred.await()

                val mapCurrentWeather: CurrentWeatherUi =
                    currentWeatherDomainToHomeUiMapper.map(awaitCurrentWeather)
                val mapWeatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(awaitWeatherForFiveDays)

                val weatherHelper = weatherDataConverter.toZoneClusterItem(
                    currentWeatherResult = mapCurrentWeather,
                    latLng = location,
                    weatherForFiveDaysUi = mapWeatherForFiveDaysUiModel.list.firstOrNull()
                        ?: WeatherForFiveDaysResultUi.unknown
                )
                _uiState.tryEmit(
                    MapState(
                        lastKnownLocation = lastKnownLocation,
                        clusterItems = persistentListOf(weatherHelper),
                        cityName = sharedPreferences.getSavedCityName().orEmpty()
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                toastNotificationManger.showToast(R.string.something_went_wrong)
            }
        }
    }

    fun getDeviceLocation() {
        viewModelScope.launch {
            try {
                val location = dependencies.getLocationTrackerManager().fetchCurrentLocation()
                if (location != null) {
                    _uiState.value = _uiState.value.copy(
                        lastKnownLocation = location,
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                toastNotificationManger.showToast(R.string.something_went_wrong)
            }
        }
    }

    fun setupClusterManager(map: GoogleMap): ZoneClusterManager {
        val clusterManager = zoneClusterManagerFactory.create(map)
        clusterManager.addItems(state.value.clusterItems)
        return clusterManager
    }

    fun calculateZoneLatLngBounds(): LatLngBounds {
        val latLngs = state.value.clusterItems.map {
            it.polygonOptions.points.map { LatLng(it.latitude, it.longitude) }
        }.flatten()
        return latLngs.calculateCameraViewPoints().getCenterOfPolygon()
    }
}

@Suppress("UNCHECKED_CAST")
class MapViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<MapViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MapViewModel::class.java)
        return viewModelProvider.get() as T
    }
}