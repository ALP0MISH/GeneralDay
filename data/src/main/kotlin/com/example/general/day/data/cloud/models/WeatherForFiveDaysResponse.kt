package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class WeatherForFiveDaysResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherForFiveDaysResultCloud>,
    @SerializedName("message")
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysResponse(
            city = City.unknown,
            cod = String(),
            cnt = -1,
            list = emptyList(),
            message = -1
        )
    }
}