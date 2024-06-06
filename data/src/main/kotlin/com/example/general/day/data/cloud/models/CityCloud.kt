package com.example.general.day.data.cloud.models


import com.google.gson.annotations.SerializedName

data class CityCloud(
    @SerializedName("coord")
    val coordinates: CoordinatesCloud,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
){
    companion object {
        val unknown = CityCloud(
            coordinates = CoordinatesCloud(lat = 0.0, lon = 0.0),
            country = String(),
            id = -1,
            name = String(),
            sunrise = -1,
            sunset = -1
        )
    }
}