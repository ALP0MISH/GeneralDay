package com.example.general.day.domain.di

import com.example.general.day.domain.use.case.FetchWeatherByCity
import com.example.general.day.domain.use.case.FetchWeatherByCityImpl
import com.example.general.day.domain.use.case.FetchWeatherUseCase
import com.example.general.day.domain.use.case.FetchWeatherUseCaseImpl
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCaseImpl
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UserCaseModule {

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
}