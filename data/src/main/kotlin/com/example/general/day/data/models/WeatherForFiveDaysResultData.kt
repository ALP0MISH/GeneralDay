package com.example.general.day.data.models

data class WeatherForFiveDaysResultData(
    val clouds: CloudsData,
    val time: Int,
    val timeText: String,
    val weatherTemperature: WeatherTemperatureData,
    val probabilityOfPrecipitation: Double,
    val rainAndSnow: ForRainOrSnowData,
    val snow: ForRainOrSnowData,
    val systemInformation: WeatherSystemInformationData,
    val visibility: Int,
    val weather: List<WeatherData>,
    val wind: WindData,
) {
    companion object {
        val unknown = WeatherForFiveDaysResultData(
            clouds = CloudsData(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperatureData.unknown,
            probabilityOfPrecipitation = 0.0,
            rainAndSnow = ForRainOrSnowData(h = 0.0),
            snow = ForRainOrSnowData(h = 0.0),
            systemInformation = WeatherSystemInformationData(pod = String()),
            visibility = -1,
            weather = emptyList(),
            wind = WindData(degrees = -1, speed = 0.0)
        )
    }
}