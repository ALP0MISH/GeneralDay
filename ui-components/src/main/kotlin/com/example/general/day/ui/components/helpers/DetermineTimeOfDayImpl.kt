package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.helpers.TimeOfDayEnum.DawnDusk
import com.example.general.day.ui.components.helpers.TimeOfDayEnum.Day
import com.example.general.day.ui.components.helpers.TimeOfDayEnum.Night
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.util.Calendar
import javax.inject.Inject

private const val Timestamp = 1000
private const val SunsetTime = 2 * 60 * 60 * 1000
private const val NumberSix = 6
private const val NumberZero = 0
private const val NumberSeventeen = 17
private const val NumberFiftyNine = 59
private const val SimpleDateFormatTime = "d MMMM, EE"
private const val SimpleDateFormatDataAndTime = "yyyy-MM-dd HH:mm:ss"
private const val Language = "ru"

class DetermineTimeOfDayImpl @Inject constructor() : DetermineTimeOfDay {

    override fun determineTimeOfDay(
        timestamp: Long,
        weatherSystemInfo: WeatherSystemInformationUi
    ): String {
        val calendar = Calendar.getInstance().apply { timeInMillis = timestamp * Timestamp }
        val currentTime = calendar.timeInMillis

        val sunriseCalendar = Calendar.getInstance()
            .apply { timeInMillis = weatherSystemInfo.sunrise.toLong() * Timestamp }
        val sunsetCalendar =
            Calendar.getInstance()
                .apply { timeInMillis = weatherSystemInfo.sunset.toLong() * Timestamp }

        return when (currentTime) {
            in sunriseCalendar.timeInMillis..sunsetCalendar.timeInMillis -> Day.name
            in (sunsetCalendar.timeInMillis - SunsetTime)..sunsetCalendar.timeInMillis -> Night.name
            in sunriseCalendar.timeInMillis..(sunriseCalendar.timeInMillis + SunsetTime) -> DawnDusk.name
            else -> Night.name
        }
    }

    override fun isDayOrNight(timestamp: Long): Boolean {
        val instant = Instant.ofEpochSecond(timestamp)
        val localTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalTime()
        return localTime in LocalTime.of(NumberSix, NumberZero)..LocalTime.of(
            NumberSeventeen, NumberFiftyNine
        )
    }
}