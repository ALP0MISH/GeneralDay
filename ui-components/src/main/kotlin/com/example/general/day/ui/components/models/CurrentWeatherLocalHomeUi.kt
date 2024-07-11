package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class CurrentWeatherLocalHomeUi(
    val id: Int,
    val code: Int,
    val lat: Double,
    val lon: Double,
    val feelsLike: String,
    val temperature: String,
    val tempMax: String,
    val tempMin: String,
    val cityName: String,
    val weatherIcon: Int
)