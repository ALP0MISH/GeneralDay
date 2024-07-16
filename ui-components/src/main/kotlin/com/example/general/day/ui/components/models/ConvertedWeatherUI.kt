package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ConvertedWeatherUI(
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
        val unknown = ConvertedWeatherUI(
            monthAndDay = persistentListOf(),
            temperature = persistentListOf(),
            temperatureMax = String(),
            temperatureMin = String(),
            feelsLikeTemperature = String(),
            weatherIcon = persistentListOf(),
            eachThreeTime = persistentListOf(),
            weatherBackgroundImage = 0,
            currentTemperature = String(),
            currentWeatherIcon = 0,
            currentMonthAndDay = String(),
            cityWeather = String()
        )
        val preview = ConvertedWeatherUI(
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