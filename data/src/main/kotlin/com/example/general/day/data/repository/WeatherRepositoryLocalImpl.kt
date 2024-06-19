package com.example.general.day.data.repository

import com.example.general.day.data.local.source.WeatherLocalDataSource
import com.example.general.day.data.mappers.CurrentWeatherLocalDataToCurrentWeatherLocalDomainMapper
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.repository.WeatherRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryLocalImpl @Inject constructor (
    private val dataSource: WeatherLocalDataSource,
    private val dataToDomain: CurrentWeatherDomainToCurrentWeatherDataMapper,
    private val localToDomain: CurrentWeatherLocalDataToCurrentWeatherLocalDomainMapper,
) : WeatherRepositoryLocal {

    override suspend fun saveCurrentWeatherLocal(currentWeatherLocal: CurrentWeatherLocalDomain) {
        return dataSource.saveCurrentWeatherLocal(dataToDomain.map(currentWeatherLocal))
    }

    override fun observeCurrentWeather(): Flow<List<CurrentWeatherLocalDomain>> =
        dataSource.observeCurrentWeather().map { weather ->
            weather.map(localToDomain::map)
        }
}