package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName

data class ForRainOrSnowCloud(
    @SerializedName("3h")
    val hour: Double
)