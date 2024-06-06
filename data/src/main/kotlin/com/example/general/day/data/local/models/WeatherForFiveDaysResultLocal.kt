package com.example.general.day.data.local.models

data class WeatherForFiveDaysResultLocal(
    val localClouds: CloudsLocal,
    val time: Int,
    val timeText: String,
    val localMain: WeatherTemperatureLocal,
    val probabilityOfPrecipitation: Double,
    val localRainAndSnow: ForRainOrSnowLocal,
    val snow: ForRainOrSnowLocal,
    val localSystemInformation: WeatherSystemInformationLocal,
    val visibility: Int,
    val localWeather: List<WeatherLocal>,
    val localWind: WindLocal
) {
    companion object {
        val unknown = WeatherForFiveDaysResultLocal(
            localClouds = CloudsLocal(all = -1),
            time = -1,
            timeText = String(),
            localMain = WeatherTemperatureLocal.unknown,
            probabilityOfPrecipitation = 0.0,
            localRainAndSnow = ForRainOrSnowLocal(h = 0.0),
            snow = ForRainOrSnowLocal(h = 0.0),
            localSystemInformation = WeatherSystemInformationLocal(pod = String()),
            visibility = -1,
            localWeather = emptyList(),
            localWind = WindLocal(degrees = -1, speed = 0.0)
        )
    }
}