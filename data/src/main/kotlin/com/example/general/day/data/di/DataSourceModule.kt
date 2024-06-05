package com.example.general.day.data.di

import com.example.general.day.data.data.source.FetchWeatherCloudDataSource
import com.example.general.day.data.data.source.FetchWeatherCloudDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {

    @Binds
    fun bindFetchWeatherCloud(
        implementation: FetchWeatherCloudDataSourceImpl
    ): FetchWeatherCloudDataSource
}