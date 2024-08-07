package com.example.general.day.data.di

import android.content.Context
import androidx.room.Room
import com.example.general.day.data.local.database.WeatherDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val WEATHER_DATABASE = "weather_database"

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideWeatherDatabase(context: Context): WeatherDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDataBase::class.java,
            WEATHER_DATABASE
        ).build()
    }
}