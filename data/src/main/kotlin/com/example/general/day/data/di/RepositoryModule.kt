package com.example.general.day.data.di

import com.example.general.day.data.repository.WeatherRepositoryCloudImpl
import com.example.general.day.data.repository.WeatherRepositoryLocalImpl
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import com.example.general.day.domain.repository.WeatherRepositoryLocal
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun provideWeatherRepositoryCloud(
        implementation: WeatherRepositoryCloudImpl
    ): WeatherRepositoryCloud

    @Binds
    fun provideWeatherRepositoryLocal(
        implementation: WeatherRepositoryLocalImpl
    ): WeatherRepositoryLocal
}