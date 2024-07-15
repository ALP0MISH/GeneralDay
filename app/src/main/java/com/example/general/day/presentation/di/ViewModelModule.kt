package com.example.general.day.presentation.di

import com.example.general.day.core.managers.LocationTrackerManager
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.use.case.FetchWeatherByCity
import com.example.general.day.domain.use.case.FetchWeatherUseCase
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.favorite.impl.di.FavoriteViewModelFactory
import com.example.general.day.home.impl.ui.di.HomeViewModelFactory
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherHomeUiToDomainMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToHomeUiMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideFavoriteViewModelFactory(
        fetchWeatherByCity: FetchWeatherByCity,
        saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
        currentWeatherLocalDomainToHomeUiMapper: CurrentWeatherLocalDomainToHomeUiMapper,
        currentWeatherDomainToHomeUiMapper: CurrentWeatherDomainToHomeUiMapper,
        currentWeatherHomeUiToDomainMapper: CurrentWeatherHomeUiToDomainMapper,
        observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
        showToastManager: ShowToastManager,
    ): FavoriteViewModelFactory {
        return FavoriteViewModelFactory(
            fetchWeatherByCity,
            saveCurrentWeatherUseCase,
            currentWeatherLocalDomainToHomeUiMapper,
            currentWeatherDomainToHomeUiMapper,
            currentWeatherHomeUiToDomainMapper,
            observeCurrentWeatherUseCase,
            showToastManager,
        )
    }

    @Provides
    @Singleton
    fun provideHomeViewModelFactory(
         fetchWeatherUseCase: FetchWeatherUseCase,
         fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToHomeUiMapper,
       fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToHomeUiMapper,
         locationTrackerManager: LocationTrackerManager,
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            fetchWeatherUseCase,
            fetchCurrentWeatherToHomeUi,
            fetchWeatherDomainToHomeUiMapper,
            locationTrackerManager,
        )
    }
}