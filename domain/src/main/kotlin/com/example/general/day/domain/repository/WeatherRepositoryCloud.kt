package com.example.general.day.domain.repository

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain

interface WeatherRepositoryCloud {
    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double,
    ): CurrentWeatherDomain

    suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double,
    ): WeatherForFiveDaysDomain

    suspend fun fetchCurrentCityWeather(
        cityName: String,
    ): CurrentWeatherDomain

    suspend fun fetchWeatherCityForFiveDays(
        cityName: String,
    ): WeatherForFiveDaysDomain
}