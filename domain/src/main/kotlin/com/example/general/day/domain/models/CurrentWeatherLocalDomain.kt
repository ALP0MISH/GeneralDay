package com.example.general.day.domain.models

data class CurrentWeatherLocalDomain(
    val id: Int,
    val code: Int,
    val localCoordinates: CoordinatesDomain,
    val localWeatherTemperature: WeatherTemperatureDomain,
    val name: String,
)