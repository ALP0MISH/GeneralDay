package com.example.general.day.ui.components.models

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
            timeText = "2024-06-28 09:00:00",
            weatherTemperature = WeatherTemperatureHomeUi.unknown,
            probabilityOfPrecipitation = 0.0,
            rain = ForRainOrSnowHomeUi(hour = 0.0),
            snow = ForRainOrSnowHomeUi(hour = 0.0),
            systemInformation = WeatherSystemInformationHomeUi(
                partOfDay = String(),
                sunset = 0,
                sunrise =0
            ),
            visibility = -1,
            weather = persistentListOf(
                WeatherHomeUi(
                    description = "Cloudy",
                    "frverаvgere",
                    24454,
                    "fwfwefwefwe"
                ),
                WeatherHomeUi(description = "Cloudy", "frvervgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherHomeUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe")
            ),
            wind = WindHomeUi(degrees = -1, speed = 0.0)
        )
    }
}