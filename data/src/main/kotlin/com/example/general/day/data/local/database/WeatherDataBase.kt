package com.example.general.day.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.general.day.data.local.dao.WeatherDao
import com.example.general.day.data.local.models.CurrentWeatherLocal

@Database(
    entities = [CurrentWeatherLocal::class],
    version = 1
)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}