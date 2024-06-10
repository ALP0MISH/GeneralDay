package com.example.general.day.data.local.source

import android.util.Log
import com.example.general.day.data.local.dao.WeatherDao
import com.example.general.day.data.local.models.CurrentWeatherLocal
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor(
    private val weatherDao: WeatherDao
) : WeatherLocalDataSource {

    override suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocal) {
        return try {
            weatherDao.saveCurrentWeatherLocal(currentWeatherLocal)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalArgumentException("Failed to save current weather local", e)
        }
    }

    override fun observeCurrentWeather(): Flow<List<CurrentWeatherLocal>> {
        return try {
            weatherDao.observeCurrentWeather()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalArgumentException("Failed to observe current weather local", e)
        }
    }
}