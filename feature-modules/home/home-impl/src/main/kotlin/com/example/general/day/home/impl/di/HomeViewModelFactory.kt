package com.example.general.day.home.impl.di

import com.example.general.day.core.managers.LocationTrackerManager
import com.example.general.day.core.viewModel.helper.ViewModelFactory
import com.example.general.day.domain.use.case.FetchCurrentWeatherUseCase
import com.example.general.day.domain.use.case.FetchWeatherForFiveDaysUseCase
import com.example.general.day.home.impl.HomeViewModel
import com.example.general.day.home.impl.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.home.impl.mappers.WeatherForFiveDaysDomainToHomeUiMapper
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val fetchCurrentWeatherUseCase: FetchCurrentWeatherUseCase,
    private val fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToHomeUiMapper,
    private val fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToHomeUiMapper,
    private val fetchWeatherForFiveDaysUseCase: FetchWeatherForFiveDaysUseCase,
    private val locationTrackerManager: LocationTrackerManager,
) :
    ViewModelFactory<HomeViewModel> {
    override fun create(): HomeViewModel {
        return HomeViewModel(
            fetchCurrentWeatherUseCase = fetchCurrentWeatherUseCase,
            fetchCurrentWeatherToHomeUi = fetchCurrentWeatherToHomeUi,
            fetchWeatherDomainToHomeUiMapper = fetchWeatherDomainToHomeUiMapper,
            fetchWeatherForFiveDaysUseCase = fetchWeatherForFiveDaysUseCase,
            locationTrackerManager = locationTrackerManager,
        )
    }
}