package com.example.general.day.domain.models

data class CurrentWeatherLocalDomain(
    val id: Int,
    val code: Int,
    val lat: Double,
    val lon: Double,
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double,
    val name: String,
)