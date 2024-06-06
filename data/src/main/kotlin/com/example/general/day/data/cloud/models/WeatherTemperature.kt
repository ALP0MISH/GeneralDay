package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class WeatherTemperature(
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
        val unknown = WeatherTemperature(
            feelsLike = 0.0,
            temp = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}