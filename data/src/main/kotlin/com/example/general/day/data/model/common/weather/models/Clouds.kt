package com.example.general.day.data.model.common.weather.models

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int
)