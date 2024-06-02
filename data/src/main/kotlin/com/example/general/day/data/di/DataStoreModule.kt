package com.example.general.day.data.di

import com.example.general.day.data.data.source.FetchWeatherCloud
import com.example.general.day.data.data.source.FetchWeatherCloudImpl
import dagger.Binds
import dagger.Module

@Module
interface DataStoreModule {

    @Binds
    fun bindFetchWeatherCloud(
        impl: FetchWeatherCloudImpl
    ): FetchWeatherCloud
}