package com.example.general.day.domain.di

import com.example.general.day.domain.use.case.FetchCurrentCityWeatherUseCase
import com.example.general.day.domain.use.case.FetchCurrentCityWeatherUseCaseImpl
import com.example.general.day.domain.use.case.FetchCurrentWeatherUseCase
import com.example.general.day.domain.use.case.FetchCurrentWeatherUseCaseImpl
import com.example.general.day.domain.use.case.FetchWeatherCityForFiveDaysUseCase
import com.example.general.day.domain.use.case.FetchWeatherCityForFiveDaysUseCaseImpl
import com.example.general.day.domain.use.case.FetchWeatherForFiveDaysUseCase
import com.example.general.day.domain.use.case.FetchWeatherForFiveDaysUseCaseImpl
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.ObserveCurrentWeatherUseCaseImpl
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCase
import com.example.general.day.domain.use.case.SaveCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun provideFetchWeatherByCity(
        implementation: FetchWeatherCityForFiveDaysUseCaseImpl,
    ): FetchWeatherCityForFiveDaysUseCase

    @Binds
    fun provideFetchWeatherUseCase(
        implementation: FetchWeatherForFiveDaysUseCaseImpl,
    ): FetchWeatherForFiveDaysUseCase

    @Binds
    fun provideObserveCurrentWeatherUseCase(
        implementation: ObserveCurrentWeatherUseCaseImpl,
    ): ObserveCurrentWeatherUseCase

    @Binds
    fun provideSaveCurrentWeatherUseCase(
        implementation: SaveCurrentWeatherUseCaseImpl,
    ): SaveCurrentWeatherUseCase

    @Binds
    fun provideFetchCurrentCityWeatherUseCase(
        implementation: FetchCurrentCityWeatherUseCaseImpl,
    ): FetchCurrentCityWeatherUseCase

    @Binds
    fun provideFetchCurrentWeatherUseCase(
        implementation: FetchCurrentWeatherUseCaseImpl,
    ): FetchCurrentWeatherUseCase
}