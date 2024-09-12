package com.example.general.day.data.local.source

import com.example.general.day.data.models.CurrentWeatherLocalData
import kotlinx.coroutines.flow.Flow

interface WeatherLocalDataSource {

    suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocalData)

    fun observeCurrentWeather(): Flow<List<CurrentWeatherLocalData>>

    suspend fun deleteWeatherById(id: String)
}