package com.example.general.day.home.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.domain.use.case.FetchWeatherUseCase
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToDetailScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToFavoriteScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToMapScreen
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToHomeUiMapper
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.ui.core.communication.navigationParams
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class HomeViewModel @Inject constructor(
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToHomeUiMapper,
    private val fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToHomeUiMapper,
    private val locationTrackerManager: LocationTrackerManager,
    private val weatherDataHelper: WeatherDataHelper,
    private val homeFeatureDependencies: HomeFeatureDependencies,
    private val navigationCommunication: NavigationRouteFlowCommunication,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val location = locationTrackerManager.fetchCurrentLocation()
                val latitude = location?.latitude
                val longitude = location?.longitude

                if (latitude == null || longitude == null) return@launch

                val currentWeatherDeferred =
                    async { fetchWeatherUseCase.fetchCurrentWeather(latitude, longitude) }
                val weatherForFiveDaysDeferred =
                    async { fetchWeatherUseCase.fetchWeatherForFiveDays(latitude, longitude) }

                val awaitCurrentWeather = currentWeatherDeferred.await()
                val awaitWeatherForFiveDays = weatherForFiveDaysDeferred.await()

                val mapCurrentWeather = fetchCurrentWeatherToHomeUi.map(awaitCurrentWeather)
                val mapWeatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(awaitWeatherForFiveDays)

                val currentWeatherResult = weatherDataHelper.convertedWeatherForFiveDays(
                    mapWeatherForFiveDaysUiModel.list.firstOrNull()
                        ?: WeatherForFiveDaysResultHomeUi.unknown
                )
                val weatherForFiveDaysUiModelResult = weatherDataHelper.currentConvertedWeather(
                    mapCurrentWeather
                )
                _uiState.tryEmit(
                    HomeUiState.Loaded(
                        weatherForFiveDays = currentWeatherResult.toImmutableList(),
                        currentWeather = weatherForFiveDaysUiModelResult
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(HomeUiState.Error("${string.failed_to_fetch_weather} ${e.message}"))
            }
        }
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            DoNavigateToFavoriteScreen -> navigationCommunication.emit(
                navigationParams(
                    homeFeatureDependencies.getFavoriteRoute()
                )
            )

            DoNavigateToMapScreen -> navigationCommunication.emit(
                navigationParams(
                    homeFeatureDependencies.getMapRoute()
                )
            )

            is DoNavigateToDetailScreen -> navigationCommunication.emit(
                navigationParams(
                    homeFeatureDependencies.getDetailRoute(event.weatherId)
                )
            )
            HomeScreenEvent.DoChangeTheme -> TODO()
            HomeScreenEvent.DoRefreshAllData -> TODO()
        }
    }
}