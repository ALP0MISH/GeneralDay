package com.example.general.day.favorite.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.use.case.FetchWeatherByCity
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherHomeUiToDomainMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToHomeUiMapper
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

private const val SUCCESS_MESSAGE = "Город успешно добавлен"
private const val ERROR_MESSAGE = "К сожелению такого горада нет"

class FavoriteViewModel @Inject constructor(
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: CurrentWeatherLocalDomainToHomeUiMapper,
    private val currentWeatherDomainToHomeUiMapper: CurrentWeatherDomainToHomeUiMapper,
    private val currentWeatherHomeUiToDomainMapper: CurrentWeatherHomeUiToDomainMapper,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val showToastManager: ShowToastManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<FavoriteUIState>(FavoriteUIState.Loading)
    val uiState: StateFlow<FavoriteUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val state = uiState.value as FavoriteUIState.Loaded
                val currentWeatherDeferred =
                    async { fetchWeatherByCity.fetchCurrentCityWeather(cityName = state.cityName) }
                val currentWeather = currentWeatherDeferred.await()
                val weather = WeatherHelper().convertWeatherData(
                    currentWeatherDomainToHomeUiMapper.map(currentWeather)
                )
                saveCurrentWeatherUseCase(currentWeatherLocalDomainToHomeUiMapper.map(weather))
                showToastManager.showToast(SUCCESS_MESSAGE)

                observeCurrentWeatherUseCase.invoke()
                    .map { weatherList ->
                        weatherList.map(currentWeatherHomeUiToDomainMapper::map)
                    }
                    .collect { savedWeather ->
                        _uiState.tryEmit(
                            FavoriteUIState.Loaded(
                                savedWeather = savedWeather.toImmutableList()
                            )
                        )
                    }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(FavoriteUIState.Error("Failed to fetch weather: ${e.message}"))
                showToastManager.showToast(ERROR_MESSAGE)
            }
        }
    }

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.DoNavigateToBack -> onNavigateToBack()
            FavoriteEvent.DoNavigateToMapScreen -> onNavigateToMapScreen()
            FavoriteEvent.DoNavigateToSun -> onNavigateToSun()
            is FavoriteEvent.GetCityName -> onGetCityName(event.cityName)
        }
    }

    private fun onNavigateToBack() {

    }

    private fun onNavigateToMapScreen() {

    }

    private fun onNavigateToSun() {

    }

    private fun onGetCityName(value: String) {
        _uiState.update {
            FavoriteUIState.Loaded(
                cityName = value
            )
        }
    }
}