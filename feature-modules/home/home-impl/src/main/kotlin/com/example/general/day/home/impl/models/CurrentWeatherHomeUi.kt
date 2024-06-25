package com.example.general.day.home.impl.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class CurrentWeatherHomeUi(
    val base: String,
    val clouds: CloudsHomeUi,
    val cod: Int,
    val coordinates: CoordinatesHomeUi,
    val time: Int,
    val id: Int,
    val weatherTemperature: WeatherTemperatureHomeUi,
    val name: String,
    val systemInformation: WeatherSystemInformationHomeUi,
    val weather: ImmutableList<WeatherHomeUi>,
    val wind: WindHomeUi,
) {
    companion object {
        val unknown = CurrentWeatherHomeUi(
            base = String(),
            clouds = CloudsHomeUi(all = -1),
            cod = -1,
            id = -1,
            weatherTemperature = WeatherTemperatureHomeUi.unknown,
            name = String(),
            systemInformation = WeatherSystemInformationHomeUi(partOfDay = String()),
            weather = persistentListOf(),
            wind = WindHomeUi(degrees = -1, speed = 0.0),
            coordinates = CoordinatesHomeUi(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}