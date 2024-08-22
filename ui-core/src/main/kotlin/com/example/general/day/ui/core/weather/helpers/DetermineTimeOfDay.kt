package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi

interface DetermineTimeOfDay {

    fun determineTimeOfDay(
        timestamp: Long,
        weatherSystemInfo: WeatherSystemInformationUi
    ): String

    fun isDayOrNight(
        timestamp: Long,
    ): Boolean

    fun currentDay(
        weatherForFiveDaysResultUi: List<WeatherForFiveDaysResultUi>
    ): List<String>

    fun fetchEachThreeTime(
        day: List<WeatherForFiveDaysResultUi>
    ): List<String>
}