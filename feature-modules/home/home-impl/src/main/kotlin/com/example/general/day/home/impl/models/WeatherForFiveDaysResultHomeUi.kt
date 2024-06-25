package com.example.general.day.home.impl.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class WeatherForFiveDaysResultHomeUi(
    val clouds: CloudsHomeUi,
    val time: Int,
    val timeText: String,
    val weatherTemperature: WeatherTemperatureHomeUi,
    val probabilityOfPrecipitation: Double,
    val rain: ForRainOrSnowHomeUi,
    val snow: ForRainOrSnowHomeUi,
    val systemInformation: WeatherSystemInformationHomeUi,
    val visibility: Int,
    val weather: ImmutableList<WeatherHomeUi>,
    val wind: WindHomeUi,
) {
    companion object {
        val unknown = WeatherForFiveDaysResultHomeUi(
            clouds = CloudsHomeUi(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperatureHomeUi.unknown,
            probabilityOfPrecipitation = 0.0,
            rain = ForRainOrSnowHomeUi(hour = 0.0),
            snow = ForRainOrSnowHomeUi(hour = 0.0),
            systemInformation = WeatherSystemInformationHomeUi(partOfDay = String()),
            visibility = -1,
            weather = persistentListOf(),
            wind = WindHomeUi(degrees = -1, speed = 0.0)
        )
    }
}