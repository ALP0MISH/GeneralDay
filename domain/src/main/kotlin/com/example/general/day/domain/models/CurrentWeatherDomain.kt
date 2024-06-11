package com.example.general.day.domain.models

data class CurrentWeatherDomain(
    val base: String,
    val clouds: CloudsDomain,
    val cod: Int,
    val coordinates: CoordinatesDomain,
    val time: Int,
    val id: Int,
    val weatherTemperature: WeatherTemperatureDomain,
    val name: String,
    val systemInformation: WeatherSystemInformationDomain,
    val weather: List<WeatherDomain>,
    val wind: WindDomain,
) {
    companion object {
        val unknown = CurrentWeatherDomain(
            base = String(),
            clouds = CloudsDomain(all = -1),
            cod = -1,
            id = -1,
            weatherTemperature = WeatherTemperatureDomain.unknown,
            name = String(),
            systemInformation = WeatherSystemInformationDomain(partOfDay = String()),
            weather = emptyList(),
            wind = WindDomain(degrees = -1, speed = 0.0),
            coordinates = CoordinatesDomain(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}