package com.example.general.day.data.local.source

import com.example.general.day.data.local.dao.WeatherDao
import com.example.general.day.data.local.models.CurrentWeatherLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor(
    private val weatherDao: WeatherDao
) : WeatherLocalDataSource {

    override suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocal) {
        return weatherDao.saveCurrentWeatherLocal(currentWeatherLocal)
    }

    override fun fetchCurrentWeatherLocal(): Flow<List<CurrentWeatherLocal>> {
        return weatherDao.fetchCurrentWeatherLocal()
    }
}