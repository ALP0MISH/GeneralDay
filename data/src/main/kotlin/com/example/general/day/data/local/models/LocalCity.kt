package com.example.general.day.data.local.models

data class LocalCity(
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