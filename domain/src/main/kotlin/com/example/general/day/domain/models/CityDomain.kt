package com.example.general.day.domain.models

data class CityDomain(
    val coordinates: CoordinatesDomain,
    val country: String,
    val id: Int,
    val name: String,
    val sunrise: Int,
    val sunset: Int,
) {
    companion object {
        val unknown = CityDomain(
            coordinates = CoordinatesDomain(lat = 0.0, lon = 0.0),
            country = String(),
            id = -1,
            name = String(),
            sunrise = -1,
            sunset = -1
        )
    }
}