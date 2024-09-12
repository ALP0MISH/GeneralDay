package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain

interface FetchWeatherByCity {
    suspend fun fetchCurrentCityWeather(
        cityName: String,
    ): CurrentWeatherDomain

    suspend fun fetchWeatherCityForFiveDays(
        cityName: String,
    ): WeatherForFiveDaysDomain
}