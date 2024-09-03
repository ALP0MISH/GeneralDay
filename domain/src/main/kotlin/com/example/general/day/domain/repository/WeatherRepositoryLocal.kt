package com.example.general.day.domain.repository

import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import kotlinx.coroutines.flow.Flow

interface WeatherRepositoryLocal {

    suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocalDomain)

    fun observeCurrentWeather(): Flow<List<CurrentWeatherLocalDomain>>

    suspend fun deleteWeatherById(id: String)
}