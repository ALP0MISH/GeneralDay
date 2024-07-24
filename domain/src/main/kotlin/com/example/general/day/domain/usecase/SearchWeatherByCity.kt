package com.example.general.day.domain.usecase

import com.example.general.day.domain.models.SearchWeatherDomain

interface SearchWeatherByCity {

    suspend fun fetchSearchWeatherCity(cityName: String): List<SearchWeatherDomain>
}