package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain

interface FetchCurrentCityWeatherUseCase {
    suspend operator fun invoke(
        cityName: String,
    ): CurrentWeatherDomain
}