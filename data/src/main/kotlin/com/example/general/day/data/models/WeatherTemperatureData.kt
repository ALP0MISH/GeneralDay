package com.example.general.day.data.models

data class WeatherTemperatureData(
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        val unknown = WeatherTemperatureData(
            feelsLike = 0.0,
            temperature = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}