package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain

interface FetchCurrentWeatherUseCase {

    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
    ): CurrentWeatherDomain
}