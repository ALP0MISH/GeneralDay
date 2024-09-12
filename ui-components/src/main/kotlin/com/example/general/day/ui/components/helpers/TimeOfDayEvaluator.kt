package com.example.general.day.ui.components.helpers

interface TimeOfDayEvaluator {

    fun determineTimeOfDay(timestamp: Long): TimeOfDay

    fun isDayTime(timestamp: Long): Boolean
}