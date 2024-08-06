package com.example.general.day.data.cloud.source

import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.SearchWeatherData
import com.example.general.day.data.models.WeatherForFiveDaysData

interface FetchWeatherCloudDataSource {
    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double,
    ): CurrentWeatherData

    suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double,
    ): WeatherForFiveDaysData

    suspend fun fetchCurrentCityWeather(
        cityName: String,
    ): CurrentWeatherData

    suspend fun fetchWeatherCityForFiveDays(
        cityName: String,
    ): WeatherForFiveDaysData

    suspend fun fetchSearchWeatherCity(
        cityName: String,
    ): List<SearchWeatherData>
}