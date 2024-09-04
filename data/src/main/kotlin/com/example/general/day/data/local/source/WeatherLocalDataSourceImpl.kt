package com.example.general.day.data.local.source

import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.ui.core.R.string
import com.example.general.day.data.local.dao.WeatherDao
import com.example.general.day.data.local.mapper.CurrentWeatherLocalDataToLocalMapper
import com.example.general.day.data.local.mapper.CurrentWeatherLocalToDataMapper
import com.example.general.day.data.models.CurrentWeatherLocalData
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject


class WeatherLocalDataSourceImpl @Inject constructor(
    private val weatherDao: WeatherDao,
    private val coroutineDispatchers: CoroutineDispatchers,
    private val currentWeatherDataToLocalMapper: CurrentWeatherLocalDataToLocalMapper,
    private val dataToLocal: CurrentWeatherLocalToDataMapper,
    private val showToastNotificationManger: ToastNotificationManger,
) : WeatherLocalDataSource {

    override suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocalData) =
        withContext(coroutineDispatchers.io) {
            try {
                weatherDao.saveCurrentWeatherLocal(
                    currentWeatherDataToLocalMapper.map(
                        currentWeatherLocal
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                throw IllegalArgumentException(
                    showToastNotificationManger.getString(string.failed_to_save_weather),
                    e
                )
            }
        }

    override fun observeCurrentWeather(): Flow<List<CurrentWeatherLocalData>> {
        return try {
            weatherDao.observeCurrentWeather().map { weather ->
                weather.map(dataToLocal::map)
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalArgumentException(
                showToastNotificationManger.getString(string.failed_to_fetch_weather),
                e
            )
        }
    }

    override suspend fun deleteWeatherById(id: String) {
        return try {
            weatherDao.deleteWeatherById(id)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalArgumentException(
                showToastNotificationManger.getString(string.failed_to_save_weather),
                e
            )
        }
    }
}