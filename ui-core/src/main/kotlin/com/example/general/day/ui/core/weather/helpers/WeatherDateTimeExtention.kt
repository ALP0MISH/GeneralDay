package com.example.general.day.ui.core.weather.helpers

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val SimpleDateFormatTime = "d MMMM, EE"
private const val SimpleDateFormatDataAndTime = "yyyy-MM-dd HH:mm:ss"
private const val Language = "ru"
private const val CONVERT_KELVIN_TO_CELSIUS = 273.15
private const val Timestamp = 1000
private const val time = "HH:mm"


fun Long.getMonthAndDay(): String {
    val date = Date(this * 1000)
    val dateFormat = SimpleDateFormat("dd MMMM", Locale("ru"))
    return dateFormat.format(date)
}

fun Long.processTimestamp(): String? {
    val processedDates = mutableSetOf<String>()
    val formattedDate = this.getMonthAndDay()
    return if (processedDates.contains(formattedDate)) {
        null
    } else {
        processedDates.add(formattedDate)
        formattedDate
    }
}

fun String.getFormattedTime(): String {
    val inputFormat = SimpleDateFormat(SimpleDateFormatDataAndTime, Locale.getDefault())
    val dateTime: Date? = inputFormat.parse(this)
    val outputFormat = SimpleDateFormat(time, Locale.getDefault())
    return outputFormat.format(dateTime ?: String())
}

fun Double.kelvinToCelsius(): Int {
    return (this - CONVERT_KELVIN_TO_CELSIUS).toInt()
}

fun Double.formatTemperature(): String {
    val tempInCelsius = this.kelvinToCelsius()
    return "$tempInCelsius°"
}