package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.DawnDusk
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.Day
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.Night
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Calendar
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

    override fun currentDay(weatherForFiveDaysResultUi: List<WeatherForFiveDaysResultUi>): List<String> {
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val sortedBy = weatherForFiveDaysResultUi.sortedBy { it.timeText }
        val outputFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())

        val uniqueDates = sortedBy
            .map { timestamp ->
                dateTimeFormat.parse(timestamp.timeText)?.let { date ->
                    dateFormat.format(date)
                }
            }
        val sortedDates = uniqueDates

        return sortedDates.map { date ->
            outputFormat.format(dateFormat.parse(date ?: String()) ?: String())
        }
    }

    override fun fetchEachThreeTime(day: List<WeatherForFiveDaysResultUi>): List<String> {
        val time = day.map { it.timeText }
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val dateTimeObjects = time.map { LocalDateTime.parse(it, formatter) }
        val dateToTimes = dateTimeObjects.groupBy { it.toLocalDate() }
        val targetDate = LocalDate.parse("2024-08-20")
        val timesForDate = dateToTimes[targetDate]?.map {
            it.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"))
        } ?: emptyList()
        return timesForDate
    }
}