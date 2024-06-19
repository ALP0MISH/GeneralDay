package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.WeatherForFiveDaysDomain

interface FetchWeatherForFiveDaysUseCase {

    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
    ): WeatherForFiveDaysDomain
}