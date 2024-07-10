package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherSystemInformationHomeUi(
    val partOfDay: String,
    val sunrise: Int,
    val sunset: Int,
)