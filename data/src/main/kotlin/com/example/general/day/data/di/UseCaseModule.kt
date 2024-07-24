package com.example.general.day.data.di

import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.domain.usecase.FetchWeatherByCityImpl
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.domain.usecase.FetchWeatherUseCaseImpl
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCaseImpl
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCaseImpl
import com.example.general.day.domain.usecase.SearchWeatherByCity
import com.example.general.day.domain.usecase.SearchWeatherByCityImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun provideFetchWeatherByCity(
        implementation: FetchWeatherByCityImpl,
    ): FetchWeatherByCity

    @Binds
    fun provideFetchWeatherUseCase(
        implementation: FetchWeatherUseCaseImpl,
    ): FetchWeatherUseCase

    @Binds
    fun provideObserveCurrentWeatherUseCase(
        implementation: ObserveCurrentWeatherUseCaseImpl,
    ): ObserveCurrentWeatherUseCase

    @Binds
    fun provideSaveCurrentWeatherUseCase(
        implementation: SaveCurrentWeatherUseCaseImpl,
    ): SaveCurrentWeatherUseCase

    @Binds
    fun provideSearchWeatherByCity(
        implementation: SearchWeatherByCityImpl,
    ): SearchWeatherByCity
}