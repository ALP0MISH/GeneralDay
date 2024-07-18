package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class CurrentConvertedWeather(
    val currentMonthAndDay: String,
    val currentTemperature: String,
    val feelsLikeTemperature: String,
    val currentWeatherIcon: Int,
    val weatherBackgroundImage: Int,
    val cityName: String
) {
    companion object {
        val preview = CurrentConvertedWeather(
            feelsLikeTemperature = "20",
            weatherBackgroundImage = 324343,
            currentTemperature = "30",
            currentWeatherIcon = 2,
            currentMonthAndDay = "monday",
            cityName = "Osh"
        )
    }
}