package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class FetchCurrentCityWeatherUseCaseImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud
) : FetchCurrentCityWeatherUseCase {
    override suspend fun invoke(cityName: String): CurrentWeatherDomain {
        return repositoryCloud.fetchCurrentCityWeather(cityName)
    }
}