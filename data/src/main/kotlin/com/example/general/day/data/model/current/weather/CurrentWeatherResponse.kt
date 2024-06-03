package com.example.general.day.data.model.current.weather


import com.example.general.day.data.model.common.weather.models.Clouds
import com.example.general.day.data.model.common.weather.models.Coord
import com.example.general.day.data.model.common.weather.models.Main
import com.example.general.day.data.model.common.weather.models.Sys
import com.example.general.day.data.model.common.weather.models.Weather
import com.example.general.day.data.model.common.weather.models.Wind
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
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
)