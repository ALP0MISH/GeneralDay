package com.example.general.day.data.repository

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.source.FetchWeatherCloudDataSource
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.SearchWeatherData
import com.example.general.day.data.models.WeatherForFiveDaysData
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class WeatherRepositoryCloudImpl @Inject constructor(
    private val dataSource: FetchWeatherCloudDataSource,
    private val currentWeatherDataToDomainMapper: @JvmSuppressWildcards Mapper<CurrentWeatherData, CurrentWeatherDomain>,
    private val weatherForFiveDaysResponseDataToDomainMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysData, WeatherForFiveDaysDomain>,
    private val searchWeatherDataToDomainMapper: @JvmSuppressWildcards Mapper<SearchWeatherData, SearchWeatherDomain>
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