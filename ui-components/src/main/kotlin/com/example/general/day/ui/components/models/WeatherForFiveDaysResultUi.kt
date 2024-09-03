package com.example.general.day.ui.components.models

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.persistentListOf
import java.util.Date
import java.util.UUID

@Immutable
data class WeatherForFiveDaysResultUi(
    val clouds: CloudsUi,
    val time: Date,
    val timeText: String,
    val rain: String,
    val systemInformation: WeatherSystemInformationUi,
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
            clouds = CloudsUi(all = -1),
            time = Date(),
            timeText = String(),
            rain = String(),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunset = 0,
                sunrise = 0
            ),
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
            clouds = CloudsUi(all = 4234234),
            time = Date(),
            timeText = "2024-06-28 09:00:00",
            rain = String(),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunset = 323,
                sunrise = 3232,
            ),
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