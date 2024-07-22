package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.repository.WeatherRepositoryCloud
import javax.inject.Inject

class SearchWeatherByCityImpl @Inject constructor(
    private val repositoryCloud: WeatherRepositoryCloud
) : SearchWeatherByCity {
    override suspend fun fetchSearchWeatherCity(cityName: String): List<SearchWeatherDomain> {
        return repositoryCloud.fetchSearchWeatherCity(cityName)
    }
}