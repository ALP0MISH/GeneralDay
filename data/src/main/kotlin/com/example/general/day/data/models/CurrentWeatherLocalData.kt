package com.example.general.day.data.models

data class CurrentWeatherLocalData(
    val id: Int,
    val code: Int,
    val lat: Double,
    val lon: Double,
    val feelsLike: Double,
    val temperature: Double,
    val tempMax: Double,
    val tempMin: Double,
    val name: String,
)