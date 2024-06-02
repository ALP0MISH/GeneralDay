package com.example.general.day.data.model.common.weather.models


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double
) {
    companion object {
        val unknown = Main(
            feelsLike = 0.0,
            temp = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}