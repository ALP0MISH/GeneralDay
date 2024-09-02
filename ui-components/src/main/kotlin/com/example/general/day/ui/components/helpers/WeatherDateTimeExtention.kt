package com.example.general.day.ui.components.helpers

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val SimpleDateFormatTime = "d MMMM, EE"
private const val Time = "HH:mm"
private const val Language = "ru"
private const val CONVERT_KELVIN_TO_CELSIUS = 273.15
private const val Timestamp = 1000

fun Long.getMonthAndDay(): String {
    val date = Date(this * Timestamp)
    val dateFormat = SimpleDateFormat(SimpleDateFormatTime, Locale(Language))
    return dateFormat.format(date)
}

fun Date.toFormattedDate(pattern: String = SimpleDateFormatTime): String =
    SimpleDateFormat(pattern, Locale(Language)).format(this)

fun Date.toFormattedTime(pattern: String = Time): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)

fun Double.kelvinToCelsius(): Int {
    return (this - CONVERT_KELVIN_TO_CELSIUS).toInt()
}

fun Double.toIntegerString(): String {
    val integerPart = this.toInt()
    return integerPart.toString()
}

fun Double.formatTemperature(): String {
    val tempInCelsius = this.kelvinToCelsius()
    return "$tempInCelsius°"
}