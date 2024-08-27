package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class ConvertedWeatherForFiveDaysUI(
    val temperature: String,
    val temperatureMin: String,
    val temperatureMax: String,
    val feelsLikeTemperature: String,
    val weatherIcon: Int,
    val eachThreeTime: String,
    val dayMonthAndWeek: String,
) {
    companion object {
        val preview = ConvertedWeatherForFiveDaysUI(
            temperatureMax = "20",
            temperatureMin = "20",
            feelsLikeTemperature = "20",
            temperature = "30",
            weatherIcon = 2,
            eachThreeTime = "",
            dayMonthAndWeek = String()
        )
    }
}