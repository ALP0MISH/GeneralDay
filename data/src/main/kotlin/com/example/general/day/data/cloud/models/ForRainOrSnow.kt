package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName

data class ForRainOrSnow(
    @SerializedName("3h")
    val h: Double
)