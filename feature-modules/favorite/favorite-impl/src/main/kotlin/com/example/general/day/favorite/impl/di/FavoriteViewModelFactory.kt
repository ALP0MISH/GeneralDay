package com.example.general.day.favorite.impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.use.case.FetchWeatherByCity
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SearchWeatherByCity
import com.example.general.day.ui.core.R.string
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherHomeUiToDomainMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.SearchWeatherDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class FavoriteViewModelFactory @Inject constructor(
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: CurrentWeatherLocalDomainToHomeUiMapper,
    private val currentWeatherDomainToHomeUiMapper: CurrentWeatherDomainToHomeUiMapper,
    private val currentWeatherHomeUiToDomainMapper: CurrentWeatherHomeUiToDomainMapper,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val searchWeatherByCity: SearchWeatherByCity,
    private val searchWeatherDomainToUiMapper: SearchWeatherDomainToUiMapper,
    private val showToastManager: ShowToastManager,
    private val weatherDataHelper: WeatherDataHelper,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(
                fetchWeatherByCity = fetchWeatherByCity,
                saveCurrentWeatherUseCase = saveCurrentWeatherUseCase,
                currentWeatherLocalDomainToHomeUiMapper = currentWeatherLocalDomainToHomeUiMapper,
                currentWeatherDomainToHomeUiMapper = currentWeatherDomainToHomeUiMapper,
                currentWeatherHomeUiToDomainMapper = currentWeatherHomeUiToDomainMapper,
                observeCurrentWeatherUseCase = observeCurrentWeatherUseCase,
                showToastManager = showToastManager,
                searchWeatherDomainToUiMapper = searchWeatherDomainToUiMapper,
                weatherDataHelper = weatherDataHelper,
                searchWeatherByCity = searchWeatherByCity
            ) as T
        }
        throw IllegalArgumentException("${string.error_message}")
    }
}