package com.example.general.day.home.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.general.day.core.Mapper
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.communication.navigationParams
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoChangeTheme
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToDetailScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToFavoriteScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoNavigateToMapScreen
import com.example.general.day.home.impl.ui.HomeScreenEvent.DoRefreshAllData
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import kotlinx.collections.immutable.toImmutableList
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
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val location =
                    getLocationTrackerManager.fetchCurrentLocation()
                val latitude = location?.latitude
                val longitude = location?.longitude

                if (latitude == null || longitude == null) return@launch

                val currentWeatherDeferred =
                    async {
                        getFetchWeatherUseCase
                            .fetchCurrentWeather(latitude, longitude)
                    }
                val weatherForFiveDaysDeferred =
                    async {
                        getFetchWeatherUseCase
                            .fetchWeatherForFiveDays(latitude, longitude)
                    }

                val awaitCurrentWeather = currentWeatherDeferred.await()
                val awaitWeatherForFiveDays = weatherForFiveDaysDeferred.await()

                val mapCurrentWeather = fetchCurrentWeatherToHomeUi.map(awaitCurrentWeather)
                val mapWeatherForFiveDaysUiModel =
                    fetchWeatherDomainToHomeUiMapper.map(awaitWeatherForFiveDays)

                val currentWeatherResult =
                    getWeatherDataHelper.convertedWeatherForFiveDays(
                        mapWeatherForFiveDaysUiModel.list.firstOrNull()
                            ?: WeatherForFiveDaysResultUi.unknown
                    )
                val weatherForFiveDaysUiModelResult =
                    getWeatherDataHelper.currentConvertedWeather(
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

            is DoNavigateToDetailScreen -> TODO()
            DoRefreshAllData -> TODO()
            DoChangeTheme -> TODO()
        }
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