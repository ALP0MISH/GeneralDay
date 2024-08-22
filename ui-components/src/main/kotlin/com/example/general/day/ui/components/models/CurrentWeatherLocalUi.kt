package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class CurrentWeatherLocalUi(
    val id: String,
    val code: Int,
    val lat: Double,
    val lon: Double,
    val feelsLike: String,
    val temperature: String,
    val tempMax: String,
    val tempMin: String,
    val cityName: String,
    val weatherIcon: Int,
)