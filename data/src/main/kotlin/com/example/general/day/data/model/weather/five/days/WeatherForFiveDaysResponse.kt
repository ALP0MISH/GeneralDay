package com.example.general.day.data.model.weather.five.days


import com.example.general.day.data.model.common.weather.models.City
import com.google.gson.annotations.SerializedName

data class WeatherForFiveDaysResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherForFiveDaysResultCloud>,
    @SerializedName("message")
    val message: Int
)