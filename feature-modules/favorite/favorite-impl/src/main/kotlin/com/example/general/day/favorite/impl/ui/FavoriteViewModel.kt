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
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

private const val DebounceTime = 300L

class FavoriteViewModel @Inject constructor(
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: CurrentWeatherLocalDomainToUiMapper,
    private val currentWeatherDomainToUiMapper: CurrentWeatherDomainToUiMapper,
    private val currentWeatherHomeUiToDomainMapper: CurrentWeatherUiToDomainMapper,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val searchWeatherByCity: SearchWeatherByCity,
    private val searchWeatherDomainToUiMapper: SearchWeatherDomainToUiMapper,
    private val showToastManager: ShowToastManager,
    private val weatherDataHelper: WeatherDataHelper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<FavoriteUIState>(FavoriteUIState.Loading)
    val uiState: StateFlow<FavoriteUIState> = _uiState.asStateFlow()

    private val searchQueryFlow = MutableStateFlow(String())
    private val savedWeatherSearchQueryFlow = MutableStateFlow(String())

    init {
        searchQueryFlow.onEach { query ->
            _uiState.tryEmit(
                FavoriteUIState.Loaded(
                    query = query, isLoading = true
                )
            )
        }.debounce(DebounceTime).onEach {
            search(it)
        }.launchIn(viewModelScope)

        savedWeatherSearchQueryFlow.onEach { query ->
            _uiState.tryEmit(
                FavoriteUIState.Loaded(
                    query = query, isLoading = true
                )
            )
        }.debounce(DebounceTime).onEach {
            searchSavedWeather(it)
        }.launchIn(viewModelScope)
    }

    private fun searchSavedWeather(query: String) {
        observeCurrentWeatherUseCase.invoke()
            .map { weatherList -> weatherList.map(currentWeatherHomeUiToDomainMapper::map) }
            .onEach { savedWeather ->
                val filteredMenu =
                   filterMenuByQuery(savedWeather.toImmutableList(), query)
                _uiState.tryEmit(
                    FavoriteUIState.Loaded(
                        savedWeather = filteredMenu
                    )
                )
            }.launchIn(viewModelScope)
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
                _uiState.tryEmit(FavoriteUIState.Error("${string.failed_to_fetch_weather}"))
                showToastManager.showToast("${string.error_message}")
            }
        }
    }

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.DoNavigateToBack -> onNavigateToBack()
            FavoriteEvent.DoNavigateToMapScreen -> onNavigateToMapScreen()
            FavoriteEvent.DoChangeTheme -> onChangeTheme()
            is FavoriteEvent.GetCityName -> onGetCityName(event.cityName)
            is FavoriteEvent.DoOnValueChange -> onValueChange(event.value)
            is FavoriteEvent.DoSavedWeatherOnValueChange -> onSavedWeatherOnValueChange(event.value)
            FavoriteEvent.DoFetchCityName -> onFetchCityName()
            FavoriteEvent.DoRefreshData -> onRefreshData()
        }
    }

    private fun onFetchCityName() {
        viewModelScope.launch {
            try {
                val state = uiState.value as? FavoriteUIState.Loaded ?: return@launch
                val currentWeatherDeferred =
                    fetchWeatherByCity.fetchCurrentCityWeather(cityName = state.query)
                val weather = weatherDataHelper.convertSavedWeather(
                    currentWeatherDomainToHomeUiMapper.map(currentWeatherDeferred)
                )
                saveCurrentWeatherUseCase(currentWeatherLocalDomainToHomeUiMapper.map(weather))
                showToastManager.showToast("${string.success_message}")
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.tryEmit(FavoriteUIState.Error("${string.failed_to_fetch_weather}"))
                showToastManager.showToast("${string.error_message}")
            }
        }
    }

    private fun onNavigateToBack() {
        // TODO()
    }

    private fun onNavigateToMapScreen() {
        // TODO()
    }

    private fun onChangeTheme() {
        // TODO()
    }

    private fun onRefreshData() {
        // TODO()
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

    private fun filterMenuByQuery(
        menu: ImmutableList<CurrentWeatherLocalHomeUi>,
        query: String
    ): ImmutableList<CurrentWeatherLocalHomeUi> {
        val menuList = menu.filter { it.cityName.contains(query, ignoreCase = true) }.toImmutableList()
        return menuList
    }
}