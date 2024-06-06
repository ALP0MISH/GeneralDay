package com.example.general.day.data.models

data class CurrentWeatherData(
    val base: String,
    val clouds: CloudsData,
    val cod: Int,
    val coordinates: CoordinatesData,
    val time: Int,
    val id: Int,
    val main: WeatherTemperatureData,
    val name: String,
    val systemInformation: WeatherSystemInformationData,
    val weather: List<WeatherData>,
    val wind: WindData,
) {
    companion object {
        val unknown = CurrentWeatherData(
            base = String(),
            clouds = CloudsData(all = -1),
            cod = -1,
            id = -1,
            main = WeatherTemperatureData.unknown,
            name = String(),
            systemInformation = WeatherSystemInformationData(pod = String()),
            weather = emptyList(),
            wind = WindData(degrees = -1, speed = 0.0),
            coordinates = CoordinatesData(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}