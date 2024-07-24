package com.example.general.day.favorite.impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SearchWeatherByCity
import com.example.general.day.ui.core.R.string
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherUiToDomainMapper
import com.example.general.day.ui.components.mappers.SearchWeatherDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class FavoriteViewModelFactory @Inject constructor(
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToUiMapper: CurrentWeatherLocalDomainToUiMapper,
    private val currentWeatherDomainToUiMapper: CurrentWeatherDomainToUiMapper,
    private val currentWeatherUiToDomainMapper: CurrentWeatherUiToDomainMapper,
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
                currentWeatherLocalDomainToHomeUiMapper = currentWeatherLocalDomainToUiMapper,
                currentWeatherHomeUiToDomainMapper = currentWeatherUiToDomainMapper,
                observeCurrentWeatherUseCase = observeCurrentWeatherUseCase,
                searchWeatherByCity = searchWeatherByCity,
                showToastManager = showToastManager,
                weatherDataHelper = weatherDataHelper,
                searchWeatherDomainToUiMapper = searchWeatherDomainToUiMapper,
                currentWeatherDomainToUiMapper = currentWeatherDomainToUiMapper
            ) as T
        } else {
            throw IllegalArgumentException("${string.error_message}")
        }
    }
}