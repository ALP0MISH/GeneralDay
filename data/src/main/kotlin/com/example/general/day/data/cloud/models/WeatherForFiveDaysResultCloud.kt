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
    val main: Main,
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
            dt = -1,
            dtTxt = String(),
            main = Main.unknown,
            pop = 0.0,
            rainAndSnow = RainAndSnow(h = 0.0),
            snow = RainAndSnow(h = 0.0),
            sys = Sys(pod = String()),
            visibility = -1,
            weather = emptyList(),
            wind = Wind(degrees = -1, speed = 0.0)
        )
    }
}