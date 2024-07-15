package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.SearchWeatherDomain

interface SearchWeatherByCity {

    suspend fun fetchSearchWeatherCity(cityName: String): List<SearchWeatherDomain>
}