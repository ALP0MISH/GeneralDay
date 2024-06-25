package com.example.general.day.home.impl.models

import androidx.compose.runtime.Immutable

@Immutable
data class CityHomeUi(
    val coordinates: CoordinatesHomeUi,
    val country: String,
    val id: Int,
    val name: String,
    val sunrise: Int,
    val sunset: Int,
) {
    companion object {
        val unknown = CityHomeUi(
            coordinates = CoordinatesHomeUi(lat = 0.0, lon = 0.0),
            country = String(),
            id = -1,
            name = String(),
            sunrise = -1,
            sunset = -1
        )
    }
}