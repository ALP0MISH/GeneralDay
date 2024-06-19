package com.example.general.day.home.impl.models

data class WeatherTemperatureHomeUi(
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        val unknown = WeatherTemperatureHomeUi(
            feelsLike = 0.0,
            temperature = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}