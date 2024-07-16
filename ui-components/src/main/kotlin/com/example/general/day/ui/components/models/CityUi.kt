package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class CityUi(
    val coordinates: CoordinatesUi,
    val country: String,
    val id: Int,
    val name: String,
    val sunrise: Int,
    val sunset: Int,
) {
    companion object {
        val unknown = CityUi(
            coordinates = CoordinatesUi(lat = 0.0, lon = 0.0),
            country = String(),
            id = 0,
            name = String(),
            sunrise = 0,
            sunset = 0,
        )
        val preview = CityUi(
            coordinates = CoordinatesUi(lat = 323.323, lon = 76543.3232),
            country = "Тамбов",
            id = 54532,
            name = "Тамбов",
            sunrise = 434,
            sunset = 43434,
        )
    }
}