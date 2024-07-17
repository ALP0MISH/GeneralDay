package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class ConvertedWeatherForFiveDays(
    val dayMonthAndWeek: String,
    val temperature: String,
    val temperatureMin: String,
    val temperatureMax: String,
    val feelsLikeTemperature: String,
    val weatherIcon: Int,
    val eachThreeTime: String,
) {
    companion object {
        val preview = ConvertedWeatherForFiveDays(
            temperatureMax = "20",
            temperatureMin = "20",
            feelsLikeTemperature = "20",
            temperature = "30",
            weatherIcon = 2,
            dayMonthAndWeek = "monday",
            eachThreeTime = String()
        )
    }
}