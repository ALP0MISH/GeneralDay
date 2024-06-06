package com.example.general.day.data.local.models

data class CurrentWeatherLocal(
    val base: String,
    val localClouds: CloudsLocal,
    val code: Int,
    val localCoordinates: CoordinatesLocal,
    val time: Int,
    val id: Int,
    val localMain: WeatherTemperatureLocal,
    val name: String,
    val localSystemInformation: WeatherSystemInformationLocal,
    val localWeather: List<WeatherLocal>,
    val localWind: WindLocal
) {
    companion object {
        val unknown = CurrentWeatherLocal(
            base = String(),
            localClouds = CloudsLocal(all = -1),
            code = -1,
            id = -1,
            localMain = WeatherTemperatureLocal.unknown,
            name = String(),
            localSystemInformation = WeatherSystemInformationLocal(pod = String()),
            localWeather = emptyList(),
            localWind = WindLocal(degrees = -1, speed = 0.0),
            localCoordinates = CoordinatesLocal(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}