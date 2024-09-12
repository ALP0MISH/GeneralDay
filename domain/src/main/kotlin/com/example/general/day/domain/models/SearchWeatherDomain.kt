package com.example.general.day.domain.models

data class SearchWeatherDomain(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String,
    val localName: LocalNamesDomain
)