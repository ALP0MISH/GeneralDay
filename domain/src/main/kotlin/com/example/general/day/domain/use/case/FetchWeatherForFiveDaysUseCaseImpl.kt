package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class FetchWeatherForFiveDaysUseCaseImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud,
) : FetchWeatherForFiveDaysUseCase {

    override suspend fun invoke(latitude: Double, longitude: Double): WeatherForFiveDaysDomain {
        return repositoryCloud.fetchWeatherForFiveDays(latitude, longitude)
    }
}