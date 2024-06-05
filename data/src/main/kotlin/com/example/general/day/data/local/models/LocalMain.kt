package com.example.general.day.data.models

data class LocalMain(
    val feelsLike: Double,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        val unknown = LocalMain(
            feelsLike = 0.0,
            temp = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
        )
    }
}