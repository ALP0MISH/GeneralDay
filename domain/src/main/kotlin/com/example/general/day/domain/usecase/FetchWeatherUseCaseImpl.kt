package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class FetchWeatherUseCaseImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud,
) : FetchWeatherUseCase {
    override suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ): CurrentWeatherDomain {
        return repositoryCloud.fetchCurrentWeather(latitude, longitude)
    }

    override suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): WeatherForFiveDaysDomain {
        return repositoryCloud.fetchWeatherForFiveDays(latitude, longitude)
    }
}