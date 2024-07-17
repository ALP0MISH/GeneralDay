package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.WeatherHomeUi
import com.example.general.day.ui.components.models.WeatherSystemInformationHomeUi

interface WeatherIconHelper {

    fun fetchWeatherIcon(
        weatherHomeUi: WeatherHomeUi,
        isDayTime: Boolean
    ): Int

    fun fetchBackgroundForTimeOfDay(
        timeOfDay: Long,
        weatherSystemInfo: WeatherSystemInformationHomeUi
    ): Int
}