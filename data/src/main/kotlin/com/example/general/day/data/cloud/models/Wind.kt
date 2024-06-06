package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val degrees: Int,
    @SerializedName("speed")
    val speed: Double
)