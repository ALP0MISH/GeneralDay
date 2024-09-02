package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi

interface WeatherIconHelper {

    fun fetchWeatherIcon(
        weatherHomeUi: WeatherUi,
        isDayTime: Boolean
    ): Int

    fun fetchBackgroundForTimeOfDay(
        timeOfDay: Long,
        weatherSystemInfo: WeatherSystemInformationUi
    ): Int
}