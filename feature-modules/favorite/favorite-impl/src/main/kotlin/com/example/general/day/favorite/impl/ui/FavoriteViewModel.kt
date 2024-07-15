package com.example.general.day.favorite.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.use.case.FetchWeatherByCity
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SearchWeatherByCity
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherHomeUiToDomainMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.SearchWeatherDomainToUiMapper
import com.example.general.day.ui.components.models.CurrentWeatherLocalHomeUi
import com.example.general.day.ui.components.models.SearchWeatherUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
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
    private val searchWeatherByCity: SearchWeatherByCity,
    private val searchWeatherDomainToUiMapper: SearchWeatherDomainToUiMapper,
    private val showToastManager: ShowToastManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<FavoriteUIState>(FavoriteUIState.Loading)
    val uiState: StateFlow<FavoriteUIState> = _uiState.asStateFlow()

    private val searchQueryFlow = MutableStateFlow("")
    private val savedWeatherSearchQueryFlow = MutableStateFlow("")

    init {
        searchQueryFlow.onEach { query ->
            _uiState.tryEmit(
                FavoriteUIState.Loaded(
                    query = query, isLoading = true
                )
            )
        }.debounce(300).onEach {
            search(it)
        }.launchIn(viewModelScope)

        savedWeatherSearchQueryFlow.onEach { query ->
            _uiState.tryEmit(
                FavoriteUIState.Loaded(
                    query = query, isLoading = true
                )
            )
        }.debounce(300).onEach {
            searchSavedWeather(it)
        }.launchIn(viewModelScope)
    }

    private fun searchSavedWeather(query: String) {
        viewModelScope.launch {
            observeCurrentWeatherUseCase.invoke()
                .map { weatherList -> weatherList.map(currentWeatherHomeUiToDomainMapper::map) }
                .collect { savedWeather ->
                    val filteredMenu =
                        WeatherHelper().filterMenuByQuery(savedWeather.toImmutableList(), query)
                    _uiState.tryEmit(
                        FavoriteUIState.Loaded(
                            savedWeather = filteredMenu
                        )
                    )
                }
        }
    }

    private fun search(query: String) {
        viewModelScope.launch {
            try {
                val result = searchWeatherByCity.fetchSearchWeatherCity(query)
                _uiState.tryEmit(
                    FavoriteUIState.Loaded(
                        searchWeather = result.sortedBy { it.name }
                            .map(searchWeatherDomainToUiMapper::map).toImmutableList(),
                    )
                )
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
            is FavoriteEvent.DoOnValueChange -> onValueChange(event.value)
            is FavoriteEvent.DoSavedWeatherOnValueChange -> onSavedWeatherOnValueChange(event.value)
            FavoriteEvent.DoFetchCityName -> onFetchCityName()
        }
    }

    private fun onFetchCityName() {
        viewModelScope.launch {
            try {
                val state = uiState.value as FavoriteUIState.Loaded
                val currentWeatherDeferred =
                    async { fetchWeatherByCity.fetchCurrentCityWeather(cityName = state.query) }
                val currentWeather = currentWeatherDeferred.await()
                val weather = WeatherHelper().convertWeatherData(
                    currentWeatherDomainToHomeUiMapper.map(currentWeather)
                )
                saveCurrentWeatherUseCase(currentWeatherLocalDomainToHomeUiMapper.map(weather))
                showToastManager.showToast(SUCCESS_MESSAGE)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(FavoriteUIState.Error("Failed to fetch weather: ${e.message}"))
                showToastManager.showToast(ERROR_MESSAGE)
            }
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
                query = value
            )
        }
    }

    private fun onValueChange(value: String) {
        searchQueryFlow.tryEmit(value)
    }

    private fun onSavedWeatherOnValueChange(value: String) {
        savedWeatherSearchQueryFlow.tryEmit(value)
    }
}