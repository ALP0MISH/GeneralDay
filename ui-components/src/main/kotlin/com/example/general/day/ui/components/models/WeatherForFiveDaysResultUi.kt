package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class WeatherForFiveDaysResultUi(
    val clouds: CloudsUi,
    val time: Int,
    val timeText: String,
    val weatherTemperature: WeatherTemperatureUi,
    val probabilityOfPrecipitation: Double,
    val rain: ForRainOrSnowUi,
    val snow: ForRainOrSnowUi,
    val systemInformation: WeatherSystemInformationUi,
    val visibility: Int,
    val weather: List<WeatherUi>,
    val wind: WindUi,
) {
    companion object {
        val unknown = WeatherForFiveDaysResultUi(
            clouds = CloudsUi(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperatureUi.unknown,
            probabilityOfPrecipitation = 0.0,
            rain = ForRainOrSnowUi(hour = 0.0),
            snow = ForRainOrSnowUi(hour = 0.0),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunset = 0,
                sunrise =0
            ),
            visibility = -1,
            weather = listOf(
                WeatherUi(
                    description = String(),
                    icon = String(),
                    id = 0,
                    main = String()
                ),
                WeatherUi(description = String(), icon = String(), id = 0, main = String()),
            ),
            wind = WindUi(degrees = -1, speed = 0.0)
        )
        val preview =WeatherForFiveDaysResultUi(
            clouds = CloudsUi(all = 4234234),
            time = 4324343,
            timeText = "2024-06-28 09:00:00",
            weatherTemperature = WeatherTemperatureUi.preview,
            probabilityOfPrecipitation = 323.323,
            rain = ForRainOrSnowUi(hour = 323.32),
            snow = ForRainOrSnowUi(hour = 323.333),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunset = 323,
                sunrise = 3232,
            ),
            visibility = 6476,
            weather = persistentListOf(
                WeatherUi(
                    description = "Cloudy",
                    icon = "frverаvgere",
                    id = 24454,
                    main = "fwfwefwefwe"
                ),
                WeatherUi(description = "Cloudy", "frvervgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe"),
                WeatherUi(description = "Cloudy", "frverаvgere", 24454, "fwfwefwefwe")
            ),
            wind = WindUi(degrees = 4324234, speed = 4324.43)
        )
    }
}