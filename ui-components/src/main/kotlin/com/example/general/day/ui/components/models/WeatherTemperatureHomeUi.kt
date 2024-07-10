package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherTemperatureHomeUi(
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        val unknown = WeatherTemperatureHomeUi(
            feelsLike = 290.53,
            temperature = 291.53,
            tempMin = 10.05454,
            tempMax = 8.0343434,
        )
    }
}