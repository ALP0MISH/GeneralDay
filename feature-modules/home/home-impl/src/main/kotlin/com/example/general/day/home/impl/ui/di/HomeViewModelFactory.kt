package com.example.general.day.home.impl.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.home.impl.ui.HomeFeatureDependencies
import com.example.general.day.home.impl.ui.HomeViewModel
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToUiMapper,
    private val fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToUiMapper,
    private val locationTrackerManager: LocationTrackerManager,
    private val weatherDataHelper: WeatherDataHelper,
    private val homeFeatureDependencies: HomeFeatureDependencies,
    private val navigationCommunication: NavigationRouteFlowCommunication,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == HomeViewModel::class)
        return HomeViewModel(
            fetchWeatherUseCase = fetchWeatherUseCase,
            fetchCurrentWeatherToHomeUi = fetchCurrentWeatherToHomeUi,
            fetchWeatherDomainToHomeUiMapper = fetchWeatherDomainToHomeUiMapper,
            locationTrackerManager = locationTrackerManager,
            weatherDataHelper = weatherDataHelper,
            homeFeatureDependencies = homeFeatureDependencies,
            navigationCommunication = navigationCommunication
        ) as T
    }
}