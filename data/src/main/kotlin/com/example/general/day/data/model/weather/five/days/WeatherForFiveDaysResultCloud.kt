package com.example.general.day.data.model.weather.five.days

import com.example.general.day.data.model.common.weather.models.Clouds
import com.example.general.day.data.model.common.weather.models.Main
import com.example.general.day.data.model.common.weather.models.RainAndSnow
import com.example.general.day.data.model.common.weather.models.Sys
import com.example.general.day.data.model.common.weather.models.Weather
import com.example.general.day.data.model.common.weather.models.Wind
import com.google.gson.annotations.SerializedName


data class WeatherForFiveDaysResultCloud(
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rainAndSnow: RainAndSnow,
    @SerializedName("snow")
    val snow: RainAndSnow,
    @SerializedName("sys")
    val sys: Sys,
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
            wind = Wind(deg = -1, speed = 0.0)
        )
    }
}