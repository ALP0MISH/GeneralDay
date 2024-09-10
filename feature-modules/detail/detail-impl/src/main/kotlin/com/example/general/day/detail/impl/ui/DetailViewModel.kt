package com.example.general.day.detail.impl.ui

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.communication.navigationParams
import com.example.general.day.detail.impl.di.DetailFeatureDependencies
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.core.R
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import kotlin.coroutines.cancellation.CancellationException

class DetailViewModel @Inject constructor(
    private val dependencies: DetailFeatureDependencies,
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val getNavigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val fetchWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
    private val fetchCurrentWeatherToHomeUi: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val getToastNotificationManger: ToastNotificationManger,
    private val connectivityManager: ConnectivityManager,
    private val weatherDataHelper: WeatherDataHelper
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val state: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private var weatherId: String = ""

    fun setWeatherId(weatherId: String) {
        this.weatherId = weatherId
        fetchWeather()
    }

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                if (!isInternetAvailable()) {
                    _uiState.tryEmit(DetailUiState.Error(getToastNotificationManger.getString(R.string.no_internet_connection)))
                    return@launch
                }
                val currentWeatherDeferred = async {
                    fetchWeatherByCity.fetchCurrentCityWeather(weatherId)
                }

                val weatherForFiveDaysDeferred = async {
                    fetchWeatherByCity.fetchWeatherCityForFiveDays(weatherId)
                }

                val awaitCurrentWeather = currentWeatherDeferred.await()
                val awaitWeatherForFiveDays = weatherForFiveDaysDeferred.await()

                val mapWeatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(awaitWeatherForFiveDays)

                val mapCurrentWeather = fetchCurrentWeatherToHomeUi.map(awaitCurrentWeather)

                val weatherForDetail = weatherDataHelper.convertWeatherForFiveDays(
                    weatherForFiveDaysUi = mapWeatherForFiveDaysUiModel.list.firstOrNull()
                        ?: WeatherForFiveDaysResultUi.unknown,
                    currentWeatherResult = mapCurrentWeather
                )

                _uiState.tryEmit(DetailUiState.Loaded(weatherForFiveDays = weatherForDetail))

            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(
                    DetailUiState.Error(
                        getToastNotificationManger.getString(R.string.failed_to_fetch_weather),
                    )
                )
            }
        }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            DetailEvent.DoNavigateToFavoriteScreen -> getNavigationRouteFlowCommunication
                .emit(
                    navigationParams(
                        dependencies.getFavoriteRoute().getRoute()
                    )
                )

            DetailEvent.DoNavigateToMapScreen -> getNavigationRouteFlowCommunication.emit(
                navigationParams(
                    dependencies.getMapRoute().getRoute()
                )
            )

            DetailEvent.DoRetryFetchWeather -> fetchWeather()
        }
    }

    @SuppressLint("MissingPermission")
    private fun isInternetAvailable(): Boolean {
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<DetailViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == DetailViewModel::class.java)
        return viewModelProvider.get() as T
    }
}