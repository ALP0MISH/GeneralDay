package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.WeatherSystemInformationHomeUi

interface DetermineTimeOfDay {

    fun determineTimeOfDay(
        timestamp: Long,
        weatherSystemInfo: WeatherSystemInformationHomeUi
    ): String

    fun isDayOrNight(
        timestamp: Long,
    ): Boolean
}