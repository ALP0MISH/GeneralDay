package com.example.general.day.data.di

import com.example.general.day.domain.usecase.DeleteWeatherByIdUseCase
import com.example.general.day.domain.usecase.DeleteWeatherByIdUseCaseImpl
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
    fun bindsFetchWeatherByCity(
        implementation: FetchWeatherByCityImpl,
    ): FetchWeatherByCity

    @Binds
    fun bindsFetchWeatherUseCase(
        implementation: FetchWeatherUseCaseImpl,
    ): FetchWeatherUseCase

    @Binds
    fun bindsObserveCurrentWeatherUseCase(
        implementation: ObserveCurrentWeatherUseCaseImpl,
    ): ObserveCurrentWeatherUseCase

    @Binds
    fun bindsSaveCurrentWeatherUseCase(
        implementation: SaveCurrentWeatherUseCaseImpl,
    ): SaveCurrentWeatherUseCase

    @Binds
    fun bindsSearchWeatherByCity(
        implementation: SearchWeatherByCityImpl,
    ): SearchWeatherByCity

    @Binds
    fun bindsDeleteWeatherByIdImpl(
        implementation: DeleteWeatherByIdUseCaseImpl,
    ): DeleteWeatherByIdUseCase
}