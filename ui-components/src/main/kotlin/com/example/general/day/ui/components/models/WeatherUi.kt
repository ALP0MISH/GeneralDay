package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherUi(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
) {
    companion object {
        val unknown = WeatherUi(
            description = String(),
            id = 0,
            main = String(),
            icon = String()
        )
    }
}