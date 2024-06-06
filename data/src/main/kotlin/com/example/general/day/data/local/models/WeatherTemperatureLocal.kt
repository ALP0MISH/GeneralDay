package com.example.general.day.data.local.models

data class WeatherTemperatureLocal(
    val feelsLike: Double,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        val unknown = WeatherTemperatureLocal(
            feelsLike = 0.0,
            temp = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}