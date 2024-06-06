package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class WeatherCloud(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)