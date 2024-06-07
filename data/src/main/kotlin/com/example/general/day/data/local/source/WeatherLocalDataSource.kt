package com.example.general.day.data.local.source

import com.example.general.day.data.local.models.CurrentWeatherLocal
import kotlinx.coroutines.flow.Flow

interface WeatherLocalDataSource {

    suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocal)

    fun fetchCurrentWeatherLocal(): Flow<List<CurrentWeatherLocal>>
}