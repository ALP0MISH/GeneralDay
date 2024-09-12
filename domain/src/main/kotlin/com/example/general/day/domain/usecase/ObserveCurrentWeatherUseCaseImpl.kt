package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.repository.WeatherRepositoryLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveCurrentWeatherUseCaseImpl @Inject constructor(
    private val repositoryLocal: WeatherRepositoryLocal,
) : ObserveCurrentWeatherUseCase {
    override fun invoke(): Flow<List<CurrentWeatherLocalDomain>> {
        return repositoryLocal.observeCurrentWeather()
    }
}