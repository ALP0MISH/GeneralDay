package com.example.general.day.home.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.managers.LocationTrackerManager
import com.example.general.day.domain.use.case.FetchWeatherUseCase
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToDetailScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToFavoriteScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToMapScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToSearchScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoRefreshAllData
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToHomeUiMapper
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
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val location = locationTrackerManager.fetchCurrentLocation()
                val latitude = location?.latitude ?: 0.0
                val longitude = location?.longitude ?: 0.0

                val currentWeatherDeferred =
                    async { fetchWeatherUseCase.fetchCurrentWeather(latitude, longitude) }
                val weatherForFiveDaysDeferred =
                    async { fetchWeatherUseCase.fetchWeatherForFiveDays(latitude, longitude) }

                val currentWeather = currentWeatherDeferred.await()
                val weatherForFiveDays = weatherForFiveDaysDeferred.await()

                val currentWeatherResult = fetchCurrentWeatherToHomeUi.map(currentWeather)
                val weatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(weatherForFiveDays)


                val convertedWeather = WeatherDataHelper().convertWeatherData(
                    currentWeatherResult,
                    weatherForFiveDaysUiModel.list
                )

                _uiState.tryEmit(
                    HomeUiState.Loaded(
                        currentWeather = currentWeatherResult,
                        weatherForFiveDays = weatherForFiveDaysUiModel,
                        convertedWeather = convertedWeather.toImmutableList()
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(HomeUiState.Error("Failed to fetch weather: ${e.message}"))
            }
        }
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            DoNavigateToDetailScreen -> NavigationHelper().navigateToDetailScreen()
            DoNavigateToFavoriteScreen -> NavigationHelper().navigateToFavoriteScreen()
            DoNavigateToMapScreen -> NavigationHelper().navigateToMapScreen()
            DoNavigateToSearchScreen -> NavigationHelper().navigateToSearchScreen()
            DoRefreshAllData -> NavigationHelper().refreshAllData()
        }
    }
}