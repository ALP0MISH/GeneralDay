package com.example.general.day.favorite.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.communication.navigationParams
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.usecase.DeleteWeatherById
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SearchWeatherByCity
import com.example.general.day.favorite.impl.di.FavoriteFeatureDependencies
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.SavedWeatherUI
import com.example.general.day.ui.components.models.SearchWeatherUi
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import kotlin.coroutines.cancellation.CancellationException

private const val DebounceTime = 300L

class FavoriteViewModel @Inject constructor(
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val weatherDataHelper: WeatherDataHelper,
    private val searchWeatherByCity: SearchWeatherByCity,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherLocalUi, CurrentWeatherLocalDomain>,
    private val currentWeatherDomainToUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val currentWeatherHomeUiToDomainMapper: @JvmSuppressWildcards Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalUi>,
    private val searchWeatherDomainToUiMapper: @JvmSuppressWildcards Mapper<SearchWeatherDomain, SearchWeatherUi>,
    private val favoriteFeatureDependencies: FavoriteFeatureDependencies,
    private val toastNotificationManger: ToastNotificationManger,
    private val deleteWeatherById: DeleteWeatherById,
    private val sharedPrefManager: SharedPrefManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoriteUIState(isLoading = true))
    val uiState: StateFlow<FavoriteUIState> = _uiState.asStateFlow()

    private val searchQueryFlow = MutableStateFlow(String())
    private val savedWeatherSearchQueryFlow = MutableStateFlow(String())

    init {
        searchQueryFlow.onEach { query ->
            _uiState.update { currentState ->
                currentState.copy(
                    query = query,
                )
            }
        }.debounce(DebounceTime)
            .onEach {
                search(it)
            }.launchIn(viewModelScope)

        searchSavedWeather()
    }

    private fun searchSavedWeather() {
        observeCurrentWeatherUseCase.invoke()
            .map { weatherList -> weatherList.map(currentWeatherHomeUiToDomainMapper::map) }
            .combine(savedWeatherSearchQueryFlow, ::Pair)
            .onEach { (savedWeather, search) ->
                val filteredMenu =
                    filterMenuByQuery(savedWeather.toImmutableList(), search)
                _uiState.update { currentState ->
                    currentState.copy(
                        savedWeatherUI = SavedWeatherUI(
                            savedWeather = filteredMenu,
                            query = search,
                        ),
                    )
                }
            }.launchIn(viewModelScope)
    }

    private fun search(query: String) {
        viewModelScope.launch {
            try {
                val result = searchWeatherByCity.fetchSearchWeatherCity(query)
                _uiState.update { currentState ->
                    currentState.copy(
                        searchResult = result.map(searchWeatherDomainToUiMapper::map)
                            .toImmutableList(),
                        cityName = sharedPrefManager.getSavedCityName() ?: String(),
                        isLoading = false
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = toastNotificationManger.getString(string.failed_to_fetch_weather)
                    )
                }
            }
        }
    }

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.DoNavigateToMapScreen -> onNavigateToMapScreen()
            is FavoriteEvent.GetCityName -> onGetCityName(event.cityName)
            is FavoriteEvent.DoSavedWeatherOnValueChange -> onSavedWeatherOnValueChange(event.value)
            FavoriteEvent.DoFetchCityName -> onFetchCityName()
            is FavoriteEvent.DoDeleteWeatherById -> onDeleteWeatherById(event.id)
            is FavoriteEvent.DoNavigateToDetailScreen -> onNavigateToDetailScreen(event.weatherId)
        }
    }

    private fun onFetchCityName() {
        viewModelScope.launch {
            try {
                val state = uiState.value as? FavoriteUIState ?: return@launch
                val currentWeatherDeferred =
                    fetchWeatherByCity.fetchCurrentCityWeather(cityName = state.query)

                if (currentWeatherDeferred.cod != -1) {
                    val weather = weatherDataHelper.convertSavedWeather(
                        currentWeatherDomainToUiMapper.map(currentWeatherDeferred)
                    )
                    saveCurrentWeatherUseCase.invoke(
                        currentWeatherLocalDomainToHomeUiMapper.map(
                            weather
                        )
                    )
                } else {
                    toastNotificationManger.showToast(string.error_message)
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = toastNotificationManger.getString(string.failed_to_fetch_weather)
                    )
                }
                toastNotificationManger.showToast(string.error_message)
            }
        }
    }

    private fun onDeleteWeatherById(id: String) {
        viewModelScope.launch {
            deleteWeatherById.invoke(id = id)
        }
    }

    private fun onNavigateToDetailScreen(weatherName: String) {
        navigationRouteFlowCommunication
            .emit(
                navigationParams(
                    favoriteFeatureDependencies.getDetailRoute(weatherName).getDetailRoure()
                )
            )
    }

    private fun onNavigateToMapScreen() {
        navigationRouteFlowCommunication.emit(
            navigationParams(favoriteFeatureDependencies.getMapRoute().getRoute())
        )
    }

    private fun onGetCityName(value: String) {
        _uiState.update { currentState ->
            currentState.copy(
                query = value
            )
        }
        searchQueryFlow.tryEmit(value)
    }

    private fun onSavedWeatherOnValueChange(value: String) {
        savedWeatherSearchQueryFlow.tryEmit(value)
    }

    private fun filterMenuByQuery(
        menu: ImmutableList<CurrentWeatherLocalUi>,
        query: String
    ): ImmutableList<CurrentWeatherLocalUi> {
        val menuList =
            menu.filter { it.cityName.contains(query, ignoreCase = true) }.toImmutableList()
        return menuList
    }
}

@Suppress("UNCHECKED_CAST")
class FavoriteViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<FavoriteViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == FavoriteViewModel::class.java)
        return viewModelProvider.get() as T
    }
}