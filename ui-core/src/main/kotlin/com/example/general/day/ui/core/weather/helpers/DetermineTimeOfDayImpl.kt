package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.DawnDusk
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.Day
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.Night
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.util.Calendar
import java.util.Date
import java.util.Locale
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

    override fun getUniqueDatesWithForecasts(list: List<WeatherForFiveDaysResultUi>): List<Pair<String, List<WeatherForFiveDaysResultUi>>> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val groupedByDate = list.groupBy { dateFormat.format(Date(it.time.toLong() * 1000)) }
        return groupedByDate.entries
            .sortedBy { it.key }
            .take(8)
            .map { it.key to it.value }
    }
}