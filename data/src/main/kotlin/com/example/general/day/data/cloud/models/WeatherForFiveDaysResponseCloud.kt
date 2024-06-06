package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class WeatherForFiveDaysResponseCloud(
    @SerializedName("city")
    val city: CityCloud,
    @SerializedName("cnt")
    val timeCount: Int,
    @SerializedName("cod")
    val code: String,
    @SerializedName("list")
    val list: List<WeatherForFiveDaysResultCloud>,
    @SerializedName("message")
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysResponseCloud(
            city = CityCloud.unknown,
            code = String(),
            timeCount = -1,
            list = emptyList(),
            message = -1
        )
    }
}