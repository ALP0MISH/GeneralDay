package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class CurrentWeatherUi(
    val base: String,
    val clouds: CloudsUi,
    val cod: Int,
    val coordinates: CoordinatesUi,
    val time: Int,
    val id: Int,
    val weatherTemperature: WeatherTemperatureUi,
    val name: String,
    val systemInformation: WeatherSystemInformationUi,
    val weather: ImmutableList<WeatherUi>,
    val wind: WindUi,
) {
    companion object {
        val unknown = CurrentWeatherUi(
            base = String(),
            clouds = CloudsUi(all = -1),
            cod = -1,
            id = -1,
            weatherTemperature = WeatherTemperatureUi.unknown,
            name = String(),
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunrise = 0,
                sunset = 0
            ),
            weather = persistentListOf(),
            wind = WindUi(degrees = -1, speed = 0.0),
            coordinates = CoordinatesUi(lat = 0.0, lon = 0.0),
            time = -1
        )
        val preview = CurrentWeatherUi(
            base = String(),
            clouds = CloudsUi(all = -1),
            cod = -1,
            id = -1,
            weatherTemperature = WeatherTemperatureUi.unknown,
            name = "Томбов",
            systemInformation = WeatherSystemInformationUi(
                partOfDay = String(),
                sunrise = 1720396672,
                sunset = 1720396672
            ),
            weather = persistentListOf(),
            wind = WindUi(degrees = -1, speed = 0.0),
            coordinates = CoordinatesUi(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}