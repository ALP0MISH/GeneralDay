package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName

data class WeatherSystemInformationCloud(
    @SerializedName("pod")
    val partOfDay: String?,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
)