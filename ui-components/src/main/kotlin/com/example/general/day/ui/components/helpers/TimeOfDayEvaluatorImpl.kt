package com.example.general.day.ui.components.helpers


import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.ZoneOffset
import java.util.Calendar
import javax.inject.Inject

private const val DAWN_START_HOUR = 6
private const val DAWN_END_HOUR = 11
private const val DAY_START_HOUR = 12
private const val DAY_END_HOUR = 17
private const val EVENING_END_HOUR = 21

private val SUMMER_ADJUSTMENT: Duration = Duration.ofHours(1)
private val WINTER_ADJUSTMENT: Duration = Duration.ofHours(-1)
private val DEFAULT_SUNRISE: LocalTime = LocalTime.of(6, 0)
private val DEFAULT_SUNSET: LocalTime = LocalTime.of(18, 0)

class TimeOfDayEvaluatorImpl @Inject constructor() : TimeOfDayEvaluator {

    override fun determineTimeOfDay(timestamp: Long): TimeOfDay {
        val calendar = Calendar.getInstance().apply { timeInMillis = timestamp * 1000 }
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        return when (hourOfDay) {
            in DAWN_START_HOUR..DAWN_END_HOUR -> TimeOfDay.DawnDusk
            in DAY_START_HOUR..DAY_END_HOUR -> TimeOfDay.Day
            in DAY_END_HOUR..EVENING_END_HOUR -> TimeOfDay.DawnDusk
            else -> TimeOfDay.Night
        }
    }

    override fun isDayTime(timestamp: Long): Boolean {
        val instant = Instant.ofEpochSecond(timestamp)
        val dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault())
        val localTime = dateTime.toLocalTime()

        val adjustedSunrise = getAdjustedTime(DEFAULT_SUNRISE, dateTime.month)
        val adjustedSunset = getAdjustedTime(DEFAULT_SUNSET, dateTime.month)
        return localTime in adjustedSunrise..adjustedSunset
    }

    private fun getAdjustedTime(defaultTime: LocalTime, month: Month): LocalTime {
        return when (month) {
            Month.JUNE, Month.JULY, Month.AUGUST -> defaultTime.minus(SUMMER_ADJUSTMENT)
            Month.DECEMBER, Month.JANUARY, Month.FEBRUARY -> defaultTime.plus(WINTER_ADJUSTMENT)
            else -> defaultTime
        }
    }
}