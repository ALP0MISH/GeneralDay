package com.example.general.day.data.model.common.weather.models


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val lat: Int,
    @SerializedName("lon")
    val lon: Int
)