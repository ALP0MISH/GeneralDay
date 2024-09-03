package com.example.general.day.home.impl.ui

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.communication.navigationParams
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToDetailScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToFavoriteScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToMapScreen
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.core.R.string
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import kotlin.coroutines.cancellation.CancellationException

class HomeViewModel @Inject constructor(
    private val dependencies: HomeFeatureDependencies,
    private val getFetchWeatherUseCase: FetchWeatherUseCase,
    private val getLocationTrackerManager: LocationTrackerManager,
    private val getWeatherDataHelper: WeatherDataHelper,
    private val getNavigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val fetchCurrentWeatherToHomeUi: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val fetchWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
    private val getToastNotificationManger: ToastNotificationManger,
    private val connectivityManager: ConnectivityManager,
    private val sharedPrefManager: SharedPrefManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchWeather()
    }

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                if (!isInternetAvailable()) {
                    _uiState.tryEmit(HomeUiState.Error(getToastNotificationManger.getString(string.no_internet_connection)))
                    return@launch
                }

                val location = getLocationTrackerManager.fetchCurrentLocation()
                val latitude = location?.latitude
                val longitude = location?.longitude

                if (latitude == null || longitude == null) {
                    return@launch
                }

                val currentWeatherDeferred = async {
                    getFetchWeatherUseCase.fetchCurrentWeather(latitude, longitude)
                }

                val weatherForFiveDaysDeferred = async {
                    getFetchWeatherUseCase.fetchWeatherForFiveDays(latitude, longitude)
                }

                val awaitCurrentWeather = currentWeatherDeferred.await()
                val awaitWeatherForFiveDays = weatherForFiveDaysDeferred.await()

                val mapCurrentWeather = fetchCurrentWeatherToHomeUi.map(awaitCurrentWeather)
                val mapWeatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(awaitWeatherForFiveDays)

                val savedCityName = sharedPrefManager.getSavedCityName()
                if (mapCurrentWeather.name != savedCityName) {
                    sharedPrefManager.saveCityName(mapCurrentWeather.name)
                }

                val currentWeatherResult =
                    getWeatherDataHelper.currentConvertedWeather(mapCurrentWeather)

                _uiState.tryEmit(
                    HomeUiState.Loaded(
                        weatherForFiveDays = mapWeatherForFiveDaysUiModel.list,
                        currentWeather = currentWeatherResult
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(
                    HomeUiState.Error(getToastNotificationManger.getString(string.failed_to_fetch_weather))
                )
            }
        }
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            DoNavigateToFavoriteScreen -> getNavigationRouteFlowCommunication
                .emit(
                    navigationParams(
                        dependencies.getFavoriteRoute().getRoute()
                    )
                )

            DoNavigateToMapScreen -> getNavigationRouteFlowCommunication
                .emit(
                    navigationParams(
                        dependencies.getMapRoute().getRoute()
                    )
                )

            is DoNavigateToDetailScreen -> onNavigateToDetailScreen(weatherName = event.weatherId)
            HomeScreenEvent.DoRetryFetchWeather -> fetchWeather()
        }
    }

    private fun onNavigateToDetailScreen(weatherName: String) {
        val route = "${dependencies.getDetailRoute().getDetailRoute()}/$weatherName"
        getNavigationRouteFlowCommunication.emit(navigationParams(route))
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
class HomeViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<HomeViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == HomeViewModel::class.java)
        return viewModelProvider.get() as T
    }
}