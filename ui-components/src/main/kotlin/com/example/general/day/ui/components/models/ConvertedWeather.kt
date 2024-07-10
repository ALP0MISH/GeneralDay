package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ConvertedWeather(
    val monthAndDay: ImmutableList<String>,
    val currentMonthAndDay: String,
    val temperature: ImmutableList<String>,
    val currentTemperature: String,
    val temperatureMin: String,
    val temperatureMax: String,
    val eachThreeTime: ImmutableList<String>,
    val feelsLikeTemperature: String,
    val weatherIcon: ImmutableList<Int>,
    val currentWeatherIcon: Int,
    val weatherBackgroundImage: Int,
    val cityWeather: String
) {
    companion object {
        val preview = ConvertedWeather(
            monthAndDay = persistentListOf(),
            temperature = persistentListOf(),
            temperatureMax = "20",
            temperatureMin = "20",
            feelsLikeTemperature = "20",
            weatherIcon = persistentListOf(),
            eachThreeTime = persistentListOf(),
            weatherBackgroundImage = 324343,
            currentTemperature = "30",
            currentWeatherIcon = 2,
            currentMonthAndDay = "monday",
            cityWeather = "Osh"
        )
    }
}