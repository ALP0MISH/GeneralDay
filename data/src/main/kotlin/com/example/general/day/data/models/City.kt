package com.example.general.day.data.models

import com.example.general.day.data.local.models.LocalCity
import com.example.general.day.data.local.models.LocalCoord

data class City(
    val localCoord: LocalCoord,
    val country: String,
    val id: Int,
    val name: String,
    val sunrise: Int,
    val sunset: Int,
) {
    companion object {
        val unknown = LocalCity(
            localCoord = LocalCoord(lat = 0.0, lon = 0.0),
            country = String(),
            id = -1,
            name = String(),
            sunrise = -1,
            sunset = -1
        )
    }
}