package com.example.general.day.home.impl.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.domain.use.case.FetchWeatherUseCase
import com.example.general.day.ui.core.R.string
import com.example.general.day.home.impl.ui.HomeViewModel
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToHomeUiMapper
import com.example.general.day.ui.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToHomeUiMapper,
    private val fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToHomeUiMapper,
    private val locationTrackerManager: LocationTrackerManager,
    private val homeFeatureDependencies: HomeFeatureDependencies,
    private val navigationCommunication: NavigationRouteFlowCommunication,
    private val weatherDataHelper: WeatherDataHelper,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                fetchWeatherUseCase = fetchWeatherUseCase,
                fetchWeatherDomainToHomeUiMapper = fetchWeatherDomainToHomeUiMapper,
                locationTrackerManager = locationTrackerManager,
                homeFeatureDependencies = homeFeatureDependencies,
                navigationCommunication = navigationCommunication,
                weatherDataHelper = weatherDataHelper,
                fetchCurrentWeatherToHomeUi = fetchCurrentWeatherToHomeUi
            ) as T
        }
        throw IllegalArgumentException(string.exception_message.toString())
    }
}