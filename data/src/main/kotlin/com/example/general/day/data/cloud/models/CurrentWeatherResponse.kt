package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Int,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    companion object {
        val unknown = CurrentWeatherResponse(
            base = String(),
            clouds = Clouds(all = -1),
            cod = -1,
            id = -1,
            main = Main.unknown,
            name = String(),
            sys = Sys(pod = String()),
            weather = emptyList(),
            wind = Wind(deg = -1, speed = 0.0),
            coord = Coord(lat = 0.0, lon = 0.0),
            dt = -1
        )
    }
}