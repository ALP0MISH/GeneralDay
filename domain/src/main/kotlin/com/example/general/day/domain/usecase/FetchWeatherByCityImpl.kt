package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class FetchWeatherByCityImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud,
) : FetchWeatherByCity {

    override suspend fun fetchCurrentCityWeather(cityName: String): CurrentWeatherDomain {
        return repositoryCloud.fetchCurrentCityWeather(cityName)
    }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysDomain {
        return repositoryCloud.fetchWeatherCityForFiveDays(cityName)
    }
}