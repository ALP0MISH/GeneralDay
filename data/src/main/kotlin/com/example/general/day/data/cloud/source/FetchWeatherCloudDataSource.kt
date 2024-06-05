package com.example.general.day.data.cloud.source

import com.example.general.day.data.cloud.models.CurrentWeatherResponse
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponse

interface FetchWeatherCloudDataSource {
    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double,
    ): CurrentWeatherResponse

    suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double,
    ): WeatherForFiveDaysResponse

    suspend fun fetchCurrentCityWeather(
        cityName: String,
    ): CurrentWeatherResponse

    suspend fun fetchWeatherCityForFiveDays(
        cityName: String,
    ): WeatherForFiveDaysResponse
}