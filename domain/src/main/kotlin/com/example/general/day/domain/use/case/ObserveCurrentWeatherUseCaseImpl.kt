package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import kotlinx.coroutines.flow.Flow

class ObserveCurrentWeatherUseCaseImpl : ObserveCurrentWeatherUseCase {
    override fun invoke(): Flow<List<CurrentWeatherLocalDomain>> {
        TODO("Not yet implemented")
    }
}