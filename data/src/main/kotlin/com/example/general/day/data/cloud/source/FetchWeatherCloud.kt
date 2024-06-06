package com.example.general.day.data.data.source

import com.example.general.day.data.model.current.weather.CurrentWeatherResponse
import com.example.general.day.data.model.weather.five.days.WeatherForFiveDaysResponse

interface FetchWeatherCloud {
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