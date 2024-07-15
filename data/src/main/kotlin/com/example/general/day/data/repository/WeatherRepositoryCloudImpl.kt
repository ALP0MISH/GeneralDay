package com.example.general.day.data.repository

import com.example.general.day.data.cloud.source.FetchWeatherCloudDataSource
import com.example.general.day.data.mappers.CurrentWeatherDataToDomainMapper
import com.example.general.day.data.mappers.SearchWeatherDataToDomainMapper
import com.example.general.day.data.mappers.WeatherForFiveDaysDataToDomainMapper
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class WeatherRepositoryCloudImpl @Inject constructor(
    private val dataSource: FetchWeatherCloudDataSource,
    private val currentWeatherDataToDomainMapper: CurrentWeatherDataToDomainMapper,
    private val weatherForFiveDaysResponseDataToDomainMapper: WeatherForFiveDaysDataToDomainMapper,
    private val searchWeatherDataToDomainMapper: SearchWeatherDataToDomainMapper
) : WeatherRepositoryCloud {

    override suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ): CurrentWeatherDomain {
        return dataSource.fetchCurrentWeather(latitude, longitude)
            .let(currentWeatherDataToDomainMapper::map)
    }

    override suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): WeatherForFiveDaysDomain {
        return dataSource.fetchWeatherForFiveDays(latitude, longitude)
            .let(weatherForFiveDaysResponseDataToDomainMapper::map)
    }

    override suspend fun fetchCurrentCityWeather(cityName: String): CurrentWeatherDomain {
        return dataSource.fetchCurrentCityWeather(cityName)
            .let(currentWeatherDataToDomainMapper::map)
    }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysDomain {
        return dataSource.fetchWeatherCityForFiveDays(cityName)
            .let(weatherForFiveDaysResponseDataToDomainMapper::map)
    }

    override suspend fun fetchSearchWeatherCity(cityName: String): List<SearchWeatherDomain> {
        return dataSource.fetchSearchWeatherCity(cityName).map(searchWeatherDataToDomainMapper::map)
    }
}