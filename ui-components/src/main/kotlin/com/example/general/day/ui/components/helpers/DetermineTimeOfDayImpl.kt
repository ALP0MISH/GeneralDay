package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.helpers.TimeOfDayEnum.DawnDusk
import com.example.general.day.ui.components.helpers.TimeOfDayEnum.Day
import com.example.general.day.ui.components.helpers.TimeOfDayEnum.Night
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.ZoneOffset
import java.util.Calendar
import javax.inject.Inject

private const val TimeStamp = 1000

class DetermineTimeOfDayImpl @Inject constructor() : DetermineTimeOfDay {

    override fun determineTimeOfDay(timestamp: Long): String {
        val calendar = Calendar.getInstance().apply { timeInMillis = timestamp * TimeStamp }
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        return when (hourOfDay) {
            in 6..11 -> DawnDusk.name
            in 12..17 -> Day.name
            in 18..21 -> DawnDusk.name
            else -> Night.name
        }
    }

    override fun isDayOrNight(timestamp: Long): Boolean {
        val instant = Instant.ofEpochSecond(timestamp)
        val dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault())
        val localTime = dateTime.toLocalTime()
        val approximateSunrise = LocalTime.of(6, 0)
        val approximateSunset = LocalTime.of(18, 0)
        val summerAdjustment = Duration.ofHours(1)
        val winterAdjustment = Duration.ofHours(-1)

        val adjustedSunrise = when (dateTime.month) {
            Month.JUNE, Month.JULY, Month.AUGUST -> approximateSunrise.minus(summerAdjustment)
            Month.DECEMBER, Month.JANUARY, Month.FEBRUARY -> approximateSunrise.plus(
                winterAdjustment
            )

            else -> approximateSunrise
        }

        val adjustedSunset = when (dateTime.month) {
            Month.JUNE, Month.JULY, Month.AUGUST -> approximateSunset.plus(summerAdjustment)
            Month.DECEMBER, Month.JANUARY, Month.FEBRUARY -> approximateSunset.minus(
                winterAdjustment
            )

            else -> approximateSunset
        }
        return localTime in adjustedSunrise..adjustedSunset
    }
}