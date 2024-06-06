package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class WeatherSystemInformation(
    @SerializedName("pod")
    val pod: String
)