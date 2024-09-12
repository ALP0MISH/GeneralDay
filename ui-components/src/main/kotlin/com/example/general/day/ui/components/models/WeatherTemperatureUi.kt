package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherTemperatureUi(
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double,
    val humidity: Int,
    ) {
    companion object {
        val unknown = WeatherTemperatureUi(
            feelsLike = 0.0,
            temperature = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
            humidity = 0
        )
        val preview = WeatherTemperatureUi(
            feelsLike = 290.53,
            temperature = 291.53,
            tempMin = 10.05454,
            tempMax = 8.0343434,
            humidity = 55
        )
    }
}