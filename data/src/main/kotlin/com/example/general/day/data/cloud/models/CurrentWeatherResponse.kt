package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val code: Int,
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("dt")
    val time: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: WeatherTemperature,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val systemInformation: WeatherSystemInformation,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    companion object {
        val unknown = CurrentWeatherResponse(
            base = String(),
            clouds = Clouds(all = -1),
            code = -1,
            id = -1,
            main = WeatherTemperature.unknown,
            name = String(),
            systemInformation = WeatherSystemInformation(pod = String()),
            weather = emptyList(),
            wind = Wind(degrees = -1, speed = 0.0),
            coordinates = Coordinates(lat = 0.0, lon = 0.0),
            time = -1
        )
    }
}