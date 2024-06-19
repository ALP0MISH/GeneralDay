package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class FetchWeatherCityForFiveDaysUseCaseImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud,
) : FetchWeatherCityForFiveDaysUseCase {

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysDomain {
        return repositoryCloud.fetchWeatherCityForFiveDays(cityName)
    }
}