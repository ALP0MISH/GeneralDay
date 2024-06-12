package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponseCloud(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: CloudsCloud,
    @SerializedName("cod")
    val code: Int,
    @SerializedName("coord")
    val coordinates: CoordinatesCloud,
    @SerializedName("dt")
    val time: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val weatherTemperature: WeatherTemperatureCloud,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val systemInformation: WeatherSystemInformationCloud,
    @SerializedName("weather")
    val weather: List<WeatherCloud>,
    @SerializedName("wind")
    val wind: WindCloud
) {
    companion object {
        val unknown = CurrentWeatherResponseCloud(
            base = String(),
            clouds = CloudsCloud(all = -1),
            code = -1,
            id = -1,
            weatherTemperature = WeatherTemperatureCloud.unknown,
            name = String(),
            systemInformation = WeatherSystemInformationCloud(partOfDay = String()),
            weather = emptyList(),
            wind = WindCloud(degrees = -1, speed = 0.0),
            coordinates = CoordinatesCloud(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}