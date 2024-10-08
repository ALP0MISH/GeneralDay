package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import kotlinx.coroutines.flow.Flow

interface ObserveCurrentWeatherUseCase {
    operator fun invoke(): Flow<List<CurrentWeatherLocalDomain>>
}