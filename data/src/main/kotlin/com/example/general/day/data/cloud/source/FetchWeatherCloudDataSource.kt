package com.example.general.day.data.cloud.source

import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud

interface FetchWeatherCloudDataSource {
    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double,
    ): CurrentWeatherResponseCloud

    suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double,
    ): WeatherForFiveDaysResponseCloud

    suspend fun fetchCurrentCityWeather(
        cityName: String,
    ): CurrentWeatherResponseCloud

    suspend fun fetchWeatherCityForFiveDays(
        cityName: String,
    ): WeatherForFiveDaysResponseCloud
}