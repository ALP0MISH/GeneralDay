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
    val probabilityOfPrecipitation: Double,
    val rain: String,
    val snow: ForRainOrSnowUi,
    val systemInformation: WeatherSystemInformationUi,
    val visibility: Int,
    val wind: WindUi,
    val main: String,
    val feelsLike: String,
    val temperature: String,
    val tempMax: String,
    val tempMin: String,
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
            probabilityOfPrecipitation = 0.0,
            rain = String(),
            snow = ForRainOrSnowUi(hour = 0.0),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunset = 0,
                sunrise = 0
            ),
            visibility = -1,
            wind = WindUi(degrees = -1, speed = 0.0),
            temperature = String(),
            tempMin = String(),
            tempMax = String(),
            feelsLike = String(),
            main = String(),
            weatherIcon = 0,
            weatherBackgroundImage = 0,
            cityName = String()
        )
        val preview = WeatherForFiveDaysResultUi(
            clouds = CloudsUi(all = 4234234),
            time = Date(),
            timeText = "2024-06-28 09:00:00",
            probabilityOfPrecipitation = 323.323,
            rain = String(),
            snow = ForRainOrSnowUi(hour = 323.333),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunset = 323,
                sunrise = 3232,
            ),
            visibility = 6476,
            temperature = String(),
            tempMin = String(),
            tempMax = String(),
            feelsLike = String(),
            main = String(),
            weatherIcon = 0,
            wind = WindUi(degrees = -1, speed = 0.0),
            weatherBackgroundImage = 0,
            cityName = String()
        )
    }
}