package com.example.general.day.domain.usecase

import com.example.general.day.domain.repository.WeatherRepositoryLocal
import javax.inject.Inject

class DeleteWeatherByIdUseCaseImpl @Inject constructor(
    private val repositoryLocal: WeatherRepositoryLocal,
) : DeleteWeatherByIdUseCase {
    override suspend fun invoke(id: String) {
        return repositoryLocal.deleteWeatherById(id)
    }
}