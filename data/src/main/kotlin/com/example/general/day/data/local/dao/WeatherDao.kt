package com.example.general.day.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.general.day.data.local.models.CurrentWeatherLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocal)

    @Query("SELECT * FROM current_weather_entity")
    fun observeCurrentWeather(): Flow<List<CurrentWeatherLocal>>
}