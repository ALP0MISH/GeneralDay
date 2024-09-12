package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.repository.WeatherRepositoryLocal
import javax.inject.Inject

class SaveCurrentWeatherUseCaseImpl @Inject constructor(
    private val repositoryLocal: WeatherRepositoryLocal,
) : SaveCurrentWeatherUseCase {
    override suspend fun invoke(currentWeatherLocal: CurrentWeatherLocalDomain) {
        return repositoryLocal.saveCurrentWeatherLocal(currentWeatherLocal)
    }
}