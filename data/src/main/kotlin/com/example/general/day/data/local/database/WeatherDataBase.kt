package com.example.general.day.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.general.day.data.local.dao.WeatherDao
import com.example.general.day.data.local.models.CurrentWeatherLocal

private const val DATA_BASE_VERSION = 1

@Database(
    entities = [CurrentWeatherLocal::class],
    version = DATA_BASE_VERSION
)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}