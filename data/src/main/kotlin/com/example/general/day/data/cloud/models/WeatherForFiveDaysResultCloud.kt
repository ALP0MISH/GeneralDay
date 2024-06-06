package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName


data class WeatherForFiveDaysResultCloud(
    @SerializedName("clouds")
    val clouds: CloudsCloud,
    @SerializedName("dt")
    val time: Int,
    @SerializedName("dt_txt")
    val timeText: String,
    @SerializedName("main")
    val weatherTemperature: WeatherTemperatureCloud,
    @SerializedName("pop")
    val probabilityOfPrecipitation: Double,
    @SerializedName("rain")
    val rainAndSnow: ForRainOrSnowCloud,
    @SerializedName("snow")
    val snow: ForRainOrSnowCloud,
    @SerializedName("sys")
    val systemInformation: WeatherSystemInformationCloud,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherCloud>,
    @SerializedName("wind")
    val wind: WindCloud
) {
    companion object {
        val unknown = WeatherForFiveDaysResultCloud(
            clouds = CloudsCloud(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperatureCloud.unknown,
            probabilityOfPrecipitation = 0.0,
            rainAndSnow = ForRainOrSnowCloud(hour = 0.0),
            snow = ForRainOrSnowCloud(hour = 0.0),
            systemInformation = WeatherSystemInformationCloud(partOfDay = String()),
            visibility = -1,
            weather = emptyList(),
            wind = WindCloud(degrees = -1, speed = 0.0)
        )
    }
}