package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName

data class SearchWeatherCloud(
    @SerializedName("country")
    val country: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("local_names")
    val localNames: LocalNamesCloud,
    @SerializedName("state")
    val state: String,
) {
    companion object {
       val unknown = SearchWeatherCloud(
           country = String(),
           lat = 0.0,
           lon = 0.0,
           name = String(),
           state = String(),
           localNames = LocalNamesCloud(String())
       )
    }
}