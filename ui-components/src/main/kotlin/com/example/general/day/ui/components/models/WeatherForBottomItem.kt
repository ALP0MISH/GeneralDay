package com.example.general.day.ui.components.models

import androidx.annotation.DrawableRes
import java.util.UUID

data class WeatherForBottomItem(
    val time: String,
    val temperature: String,
    val weatherId: String = UUID.randomUUID().toString(),
    @DrawableRes val weatherIcon: Int
)