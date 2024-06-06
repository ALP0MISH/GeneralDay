package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName

data class WeatherTemperatureCloud(
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp")
    val temperature: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double
) {
    companion object {
        val unknown = WeatherTemperatureCloud(
            feelsLike = 0.0,
            temperature = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}