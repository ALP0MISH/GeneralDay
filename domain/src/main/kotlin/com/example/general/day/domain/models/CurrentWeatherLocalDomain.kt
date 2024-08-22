package com.example.general.day.domain.models

data class CurrentWeatherLocalDomain(
    val id: String,
    val code: Int,
    val lat: Double,
    val lon: Double,
    val feelsLike: String,
    val temperature: String,
    val tempMax: String,
    val tempMin: String,
    val name: String,
    val weatherIcon: Int,
)