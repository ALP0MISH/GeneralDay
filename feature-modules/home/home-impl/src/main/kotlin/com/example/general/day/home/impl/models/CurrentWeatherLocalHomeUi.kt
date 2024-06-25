package com.example.general.day.home.impl.models

import androidx.compose.runtime.Immutable

@Immutable
data class CurrentWeatherLocalHomeUi(
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