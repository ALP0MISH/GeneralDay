package com.example.general.day.ui.components.models

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.util.Date
import java.util.UUID

@Immutable
data class WeatherForFiveDaysResultUi(
    val listTemperature: ImmutableList<Double>,
    val time: Date,
    val rain: String,
    val listTime: ImmutableList<String>,
    val wind: WindUi,
    val main: String,
    val feelsLike: String,
    val temperature: String,
    val humidity: Int,
    val tempMax: Double,
    val tempMin: Double,
    val cityName: String,
    val weatherId: String = UUID.randomUUID().toString(),
    @DrawableRes val weatherBackgroundImage: Int,
    @DrawableRes val weatherIcon: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysResultUi(
            listTemperature = persistentListOf(),
            time = Date(),
            rain = String(),
            listTime = persistentListOf(),
            wind = WindUi(degrees = -1, speed = 0.0),
            temperature = String(),
            tempMin = 0.0,
            tempMax = 0.0,
            feelsLike = String(),
            main = String(),
            weatherIcon = 0,
            weatherBackgroundImage = 0,
            cityName = String(),
            humidity = 0
        )
        val preview = WeatherForFiveDaysResultUi(
            listTemperature = persistentListOf(),
            time = Date(),
            rain = String(),
            listTime = persistentListOf(),
            temperature = String(),
            tempMin = 0.0,
            tempMax = 0.0,
            feelsLike = String(),
            main = String(),
            weatherIcon = 0,
            wind = WindUi(degrees = -1, speed = 0.0),
            weatherBackgroundImage = 0,
            cityName = String(),
            humidity = 53453
        )
    }
}