package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName

data class RainAndSnow(
    @SerializedName("3h")
    val h: Double
)