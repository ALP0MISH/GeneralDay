package com.example.general.day.ui.components.helpers

import androidx.annotation.DrawableRes
import com.example.general.day.ui.components.models.WeatherUi

interface WeatherIconProvider {

    @DrawableRes
    fun getWeatherIcon(weatherHomeUi: WeatherUi, isDayTime: Boolean): Int

    @DrawableRes
    fun getBackgroundForTimeOfDay(timeOfDay: Long): Int
}