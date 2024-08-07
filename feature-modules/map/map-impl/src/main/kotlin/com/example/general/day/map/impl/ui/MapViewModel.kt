package com.example.general.day.map.impl.ui

import android.content.Context
import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.Mapper
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.map.impl.ui.components.ZoneClusterManager
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.map.impl.di.MapFeatureDependencies
import com.example.general.day.map.impl.ui.components.calculateCameraViewPoints
import com.example.general.day.map.impl.ui.components.getCenterOfPolygon
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import kotlin.coroutines.cancellation.CancellationException

class MapViewModel @Inject constructor(
    private val currentWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val dependencies: MapFeatureDependencies,
    private val weatherDataHelper: WeatherDataHelper,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MapState())
    val state: StateFlow<MapState> = _uiState.asStateFlow()

    fun getWeatherForLocation(location: LatLng) {
        val latitude = location.latitude
        val longitude = location.longitude

        val lastKnownLocation = Location("provider_name").apply {
            this.latitude = latitude
            this.longitude = longitude
        }

        viewModelScope.launch {
            try {
                val result = fetchWeatherUseCase.fetchCurrentWeather(latitude, longitude)
                val weatherHelper = MapWeatherHelper().convertWeatherData(
                    currentWeatherDomainToHomeUiMapper.map(result), latitude, longitude
                )
                _uiState.tryEmit(
                    MapState(
                        lastKnownLocation = lastKnownLocation,
                        clusterItems = listOf(
                            weatherHelper
                        )
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                throw IllegalArgumentException("Error during API call: ${e.message}", e)
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
                throw IllegalArgumentException("Error during API call: ${e.message}", e)
            }
        }
    }

    fun setupClusterManager(
        context: Context,
        map: GoogleMap,
    ): ZoneClusterManager {
        val clusterManager = ZoneClusterManager(context, map)
        clusterManager.addItems(state.value.clusterItems)
        return clusterManager
    }

    fun calculateZoneLatLngBounds(): LatLngBounds {
        val latLngs = state.value.clusterItems.map { it.polygonOptions }
            .map { it.points.map { LatLng(it.latitude, it.longitude) } }.flatten()
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