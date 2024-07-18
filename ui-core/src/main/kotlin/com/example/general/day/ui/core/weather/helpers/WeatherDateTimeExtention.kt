package com.example.general.day.ui.core.weather.helpers

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val SimpleDateFormatTime = "d MMMM, EE"
private const val SimpleDateFormatDataAndTime = "yyyy-MM-dd HH:mm:ss"
private const val Language = "ru"
private const val CONVERT_KELVIN_TO_CELSIUS = 273.15
private const val Timestamp = 1000

fun Long.getMonthAndDay(): String {
    val date = Date(this * Timestamp)
    val dateFormat = SimpleDateFormat(SimpleDateFormatTime, Locale(Language))
    return dateFormat.format(date)
}

fun String.getFormattedTime(): String {
    val inputFormat = SimpleDateFormat(SimpleDateFormatDataAndTime, Locale(Language))
    val dateTime: Date? = inputFormat.parse(this)
    return dateTime?.time.toString()
}

fun kelvinToCelsius(kelvin: Double): Int {
    return (kelvin - CONVERT_KELVIN_TO_CELSIUS).toInt()
}

fun Double.formatTemperature(): String {
    val tempInCelsius = kelvinToCelsius(this )
    return "$tempInCelsius°"
}