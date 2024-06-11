package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain

class FetchWeatherUseCaseImpl:FetchWeatherUseCase {
    override suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ): CurrentWeatherDomain {
        TODO("Not yet implemented")
    }

    override suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): WeatherForFiveDaysDomain {
        TODO("Not yet implemented")
    }
}