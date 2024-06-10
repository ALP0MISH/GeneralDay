package com.example.general.day.data.di

import com.example.general.day.data.local.dao.WeatherDao
import com.example.general.day.data.local.database.WeatherDataBase
import dagger.Module
import dagger.Provides

@Module
class DaoModule {

    @Provides
    fun provideWeatherDao(database: WeatherDataBase): WeatherDao {
        return database.weatherDao()
    }
}