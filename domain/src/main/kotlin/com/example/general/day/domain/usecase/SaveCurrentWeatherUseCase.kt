package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherLocalDomain

interface SaveCurrentWeatherUseCase {
    suspend operator fun invoke(currentWeatherLocal: CurrentWeatherLocalDomain)
}