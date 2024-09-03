package com.example.general.day.ui.components.helpers

interface DetermineTimeOfDay {

    fun determineTimeOfDay(
        timestamp: Long,
    ): String

    fun isDayOrNight(
        timestamp: Long,
    ): Boolean
}