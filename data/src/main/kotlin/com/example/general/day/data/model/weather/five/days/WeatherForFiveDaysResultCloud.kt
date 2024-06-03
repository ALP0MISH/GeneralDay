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
)