package com.example.general.day.domain.models

data class WeatherTemperatureDomain(
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        val unknown = WeatherTemperatureDomain(
            feelsLike = 0.0,
            temperature = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}