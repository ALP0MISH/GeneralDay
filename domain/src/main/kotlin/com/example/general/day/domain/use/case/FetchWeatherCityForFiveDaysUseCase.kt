package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.WeatherForFiveDaysDomain

interface FetchWeatherCityForFiveDaysUseCase {
    suspend fun fetchWeatherCityForFiveDays(
        cityName: String,
    ): WeatherForFiveDaysDomain
}