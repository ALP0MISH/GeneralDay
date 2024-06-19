package com.example.general.day.home.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.domain.use.case.FetchCurrentWeatherUseCase
import com.example.general.day.home.impl.mappers.CurrentWeatherDomainToHomeUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.general.day.home.impl.HomeScreenEvent.DoNavigateToDetailScreen
import com.example.general.day.home.impl.HomeScreenEvent.DoNavigateToFavoriteScreen
import com.example.general.day.home.impl.HomeScreenEvent.DoNavigateToMapScreen
import com.example.general.day.home.impl.HomeScreenEvent.DoNavigateToSearchScreen
import com.example.general.day.home.impl.HomeScreenEvent.DoRefreshAllData

class HomeViewModel @Inject constructor(
    private val fetchCurrentWeatherUseCase: FetchCurrentWeatherUseCase,
    private val fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToHomeUiMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchWeather()
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            DoNavigateToDetailScreen -> TODO()
            DoNavigateToFavoriteScreen -> TODO()
            DoNavigateToMapScreen -> TODO()
            DoNavigateToSearchScreen -> TODO()
            DoRefreshAllData -> TODO()
        }
    }

    private fun fetchWeather() {
        viewModelScope.launch {
            val response = fetchCurrentWeatherUseCase.invoke(latitude = 0.0, longitude = 0.0)
            response.let { result ->
                _uiState.tryEmit(
                    HomeUiState.Loaded(weather = result.let { fetchCurrentWeatherToHomeUi::map })
                )
            }
        }
    }
}