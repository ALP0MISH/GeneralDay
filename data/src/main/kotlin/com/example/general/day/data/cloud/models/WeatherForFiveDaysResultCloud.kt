package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName


data class WeatherForFiveDaysResultCloud(
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("dt")
    val time: Int,
    @SerializedName("dt_txt")
    val timeText: String,
    @SerializedName("main")
    val weatherTemperature: WeatherTemperature,
    @SerializedName("pop")
    val probabilityOfPrecipitation: Double,
    @SerializedName("rain")
    val rainAndSnow: ForRainOrSnow,
    @SerializedName("snow")
    val snow: ForRainOrSnow,
    @SerializedName("sys")
    val systemInformation: WeatherSystemInformation,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    companion object {
        val unknown = WeatherForFiveDaysResultCloud(
            clouds = Clouds(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperature.unknown,
            probabilityOfPrecipitation = 0.0,
            rainAndSnow = ForRainOrSnow(h = 0.0),
            snow = ForRainOrSnow(h = 0.0),
            systemInformation = WeatherSystemInformation(pod = String()),
            visibility = -1,
            weather = emptyList(),
            wind = Wind(degrees = -1, speed = 0.0)
        )
    }
}