package com.example.general.day.data.models

data class CityData(
    val coordinates: CoordinatesData,
    val country: String,
    val id: Int,
    val name: String,
    val sunrise: Int,
    val sunset: Int,
) {
    companion object {
        val unknown = CityData(
            coordinates = CoordinatesData(lat = 0.0, lon = 0.0),
            country = String(),
            id = -1,
            name = String(),
            sunrise = -1,
            sunset = -1
        )
    }
}