package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherLocalDomain

interface SaveCurrentWeatherUseCase {
    suspend operator fun invoke(currentWeatherLocal: CurrentWeatherLocalDomain)
}