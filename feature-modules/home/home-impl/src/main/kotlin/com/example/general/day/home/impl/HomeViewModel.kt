package com.example.general.day.home.impl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.extantions.createMutableSharedFlowAsSingleLiveEvent
import com.example.general.day.core.managers.LocationTrackerManager
import com.example.general.day.domain.use.case.FetchCurrentWeatherUseCase
import com.example.general.day.domain.use.case.FetchWeatherForFiveDaysUseCase
import com.example.general.day.home.impl.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.home.impl.mappers.WeatherForFiveDaysDomainToHomeUiMapper
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class HomeViewModel @Inject constructor(
    private val fetchCurrentWeatherUseCase: FetchCurrentWeatherUseCase,
    private val fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToHomeUiMapper,
    private val fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToHomeUiMapper,
    private val fetchWeatherForFiveDaysUseCase: FetchWeatherForFiveDaysUseCase,
    private val locationTrackerManager: LocationTrackerManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _navControllerFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navControllerFlow: SharedFlow<String> = _navControllerFlow.asSharedFlow()

    init {
        fetchWeather()
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            HomeScreenEvent.DoNavigateToDetailScreen -> onNavigateToDetailScreen()
            HomeScreenEvent.DoNavigateToFavoriteScreen -> onNavigateToFavoriteScreen()
            HomeScreenEvent.DoNavigateToMapScreen -> onNavigateToMapScreen()
            HomeScreenEvent.DoNavigateToSearchScreen -> onNavigateToSearchScreen()
            HomeScreenEvent.DoRefreshAllData -> onRefreshAllData()
        }
    }

    private fun fetchWeather() {
        viewModelScope.launch {
            try {
                val location = locationTrackerManager.fetchCurrentLocation()
                val latitude = location?.latitude ?: 0.0
                val longitude = location?.longitude ?: 0.0

                val currentWeather = fetchCurrentWeatherUseCase.invoke(latitude, longitude)
                val weatherForFiveDays = fetchWeatherForFiveDaysUseCase.invoke(latitude, longitude)
                val weatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(weatherForFiveDays)
                val weatherUiModel = fetchCurrentWeatherToHomeUi.map(currentWeather)
                _uiState.tryEmit(
                    HomeUiState.Loaded(
                        currentWeather = weatherUiModel,
                        weatherForFiveDays = weatherForFiveDaysUiModel
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(HomeUiState.Error("Failed to fetch weather: ${e.message}"))
            }
        }
    }

    private fun onNavigateToDetailScreen() {

    }

    private fun onNavigateToFavoriteScreen() {

    }

    private fun onNavigateToMapScreen() {

    }

    private fun onNavigateToSearchScreen() {

    }

    private fun onRefreshAllData() {

    }
}