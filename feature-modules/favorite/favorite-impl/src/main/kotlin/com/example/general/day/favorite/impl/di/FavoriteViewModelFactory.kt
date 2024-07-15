package com.example.general.day.favorite.impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.use.case.FetchWeatherByCity
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherHomeUiToDomainMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToHomeUiMapper
import javax.inject.Inject

class FavoriteViewModelFactory @Inject constructor(
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: CurrentWeatherLocalDomainToHomeUiMapper,
    private val currentWeatherDomainToHomeUiMapper: CurrentWeatherDomainToHomeUiMapper,
    private val currentWeatherHomeUiToDomainMapper: CurrentWeatherHomeUiToDomainMapper,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val showToastManager: ShowToastManager,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(
                fetchWeatherByCity,
                saveCurrentWeatherUseCase,
                currentWeatherLocalDomainToHomeUiMapper,
                currentWeatherDomainToHomeUiMapper,
                currentWeatherHomeUiToDomainMapper,
                observeCurrentWeatherUseCase,
                showToastManager,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}