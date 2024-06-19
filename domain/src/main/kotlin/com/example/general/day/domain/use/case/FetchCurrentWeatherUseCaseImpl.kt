package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class FetchCurrentWeatherUseCaseImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud
) : FetchCurrentWeatherUseCase {

    override suspend fun invoke(latitude: Double, longitude: Double): CurrentWeatherDomain {
        return repositoryCloud.fetchCurrentWeather(latitude, longitude)
    }
}