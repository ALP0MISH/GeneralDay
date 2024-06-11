package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain

interface FetchWeatherUseCase {
    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double,
    ): CurrentWeatherDomain

    suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double,
    ): WeatherForFiveDaysDomain
}