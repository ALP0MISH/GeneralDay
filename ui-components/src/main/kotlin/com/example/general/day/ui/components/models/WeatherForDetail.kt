package com.example.general.day.ui.components.models

import androidx.annotation.DrawableRes
import kotlinx.collections.immutable.ImmutableList
import java.util.Date

data class WeatherForDetail(
    val listTemperature: ImmutableList<Double>,
    val time: Date,
    val rain: String,
    val listTime: ImmutableList<String>,
    val wind: WindUi,
    val main: String,
    val feelsLike: String,
    val temperature: String,
    val humidity: Int,
    val tempMax: Double,
    val tempMin: Double,
    val cityName: String,
    @DrawableRes val weatherBackgroundImage: Int,
    @DrawableRes val weatherIcon: Int
)