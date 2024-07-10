package com.example.general.day.ui.core.factories

import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.components.models.WeatherSystemInformationHomeUi
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateTimeHelper {

    fun getMonthAndDay(timestamp: Long): List<String> {
        val date = Date(timestamp * 1000L)
        val dayFormat = SimpleDateFormat("d", Locale("ru"))
        val monthFormat = SimpleDateFormat("MMMM", Locale("ru"))
        val dayOfWeekFormat = SimpleDateFormat("EE", Locale("ru"))
        val day = dayFormat.format(date)
        val month = monthFormat.format(date)
        val dayOfWeek = dayOfWeekFormat.format(date)
        return listOf("$day $month, $dayOfWeek")
    }

    fun getFormattedTimeList(weatherForFiveDaysUiModel: WeatherForFiveDaysResultHomeUi): List<String> {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ru"))
        val outputFormat = SimpleDateFormat("HH:mm", Locale("ru"))
        val dateTime: Date? = inputFormat.parse(weatherForFiveDaysUiModel.timeText)
        return listOf(outputFormat.format(dateTime ?: Date()))
    }

    fun getFormattedTime(currentWeatherResult: CurrentWeatherHomeUi): Long {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ru"))
        val dateTime: Date? = inputFormat.parse(currentWeatherResult.time.toString())
        return dateTime?.time ?: Date().time
    }

    fun isDayTime(timestamp: Long): Boolean {
        val calendar = Calendar.getInstance().apply { timeInMillis = timestamp * 1000 }
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        return hour in 6..18
    }

    fun determineTimeOfDay(
        timestamp: Long,
        weatherSystemInfo: WeatherSystemInformationHomeUi
    ): String {
        val calendar = Calendar.getInstance().apply { timeInMillis = timestamp * 1000 }
        val currentTime = calendar.timeInMillis

        val sunriseCalendar = Calendar.getInstance()
            .apply { timeInMillis = weatherSystemInfo.sunrise.toLong() * 1000 }
        val sunsetCalendar =
            Calendar.getInstance().apply { timeInMillis = weatherSystemInfo.sunset.toLong() * 1000 }

        return when (currentTime) {
            in sunriseCalendar.timeInMillis..sunsetCalendar.timeInMillis -> "day"
            in (sunsetCalendar.timeInMillis - 2 * 60 * 60 * 1000)..sunsetCalendar.timeInMillis -> "dawn_dusk"
            in sunriseCalendar.timeInMillis..(sunriseCalendar.timeInMillis + 2 * 60 * 60 * 1000) -> "dawn_dusk"
            else -> "night"
        }
    }

    fun getBackgroundForTimeOfDay(timeOfDay: String): Int {
        return when (timeOfDay) {
            "dawn_dusk" -> drawable.light
            "day" -> drawable.light
            "night" -> drawable.light
            else -> drawable.light
        }
    }
}

