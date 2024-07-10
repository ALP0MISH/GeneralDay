package com.example.general.day.data.models

data class CurrentWeatherLocalData(
    val id: Int,
    val code: Int,
    val lat: Double,
    val lon: Double,
    val feelsLike: String,
    val temperature: String,
    val tempMax: String,
    val tempMin: String,
    val name: String,
    val weatherIcon: Int,
)