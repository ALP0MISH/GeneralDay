package com.example.general.day.data.di

import com.example.general.day.data.cloud.source.FetchWeatherCloudDataSource
import com.example.general.day.data.cloud.source.FetchWeatherCloudDataSourceImpl
import com.example.general.day.data.local.source.WeatherLocalDataSource
import com.example.general.day.data.local.source.WeatherLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {

    @Binds
    fun bindFetchWeatherCloud(
        implementation: FetchWeatherCloudDataSourceImpl
    ): FetchWeatherCloudDataSource

    @Binds
    fun bindWeatherLocalDataSource(
        implementation: WeatherLocalDataSourceImpl
    ): WeatherLocalDataSource
}