package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherHomeUi(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
) {
    companion object {
        val unknown = WeatherHomeUi(
            description = String(),
            id = 0,
            main = String(),
            icon = String()
        )
    }
}