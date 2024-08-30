package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.models.WeatherSystemInformationUi

interface DetermineTimeOfDay {

    fun determineTimeOfDay(
        timestamp: Long,
        weatherSystemInfo: WeatherSystemInformationUi
    ): String

    fun isDayOrNight(
        timestamp: Long,
    ): Boolean
}