package com.example.general.day.domain.models

data class WeatherForFiveDaysResultDomain(
    val clouds: CloudsDomain,
    val time: Int,
    val timeText: String,
    val weatherTemperature: WeatherTemperatureDomain,
    val probabilityOfPrecipitation: Double,
    val rain: ForRainOrSnowDomain,
    val snow: ForRainOrSnowDomain,
    val systemInformation: WeatherSystemInformationDomain,
    val visibility: Int,
    val weather: List<WeatherDomain>,
    val wind: WindDomain,
) {
    companion object {
        val unknown = WeatherForFiveDaysResultDomain(
            clouds = CloudsDomain(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperatureDomain.unknown,
            probabilityOfPrecipitation = 0.0,
            rain = ForRainOrSnowDomain(hour = 0.0),
            snow = ForRainOrSnowDomain(hour = 0.0),
            systemInformation = WeatherSystemInformationDomain(partOfDay = String(), sunrise = 0, sunset = 0),
            visibility = -1,
            weather = emptyList(),
            wind = WindDomain(degrees = -1, speed = 0.0)
        )
    }
}