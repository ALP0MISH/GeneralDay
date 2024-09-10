package com.example.general.day.ui.components.helpers

import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

private const val SimpleDateFormatTime = "d MMMM, EE"
private const val SimpleMonthDateFormatTime = "yyyy-MM-dd HH:mm:ss"
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

fun List<WeatherForFiveDaysResultDomain>.getListTime(): ImmutableList<String> {
    return this.map { weather ->
        Date(TimeUnit.SECONDS.toMillis(weather.time)).toFormattedTime()
    }.toImmutableList()
}

fun List<WeatherForFiveDaysResultDomain>.findMaxValue(): Double? {
    return this.maxOfOrNull { it.weatherTemperature.tempMax.kelvinToCelsius().toDouble() }
}

fun List<WeatherForFiveDaysResultDomain>.findMinValue(): Double? {
    return this.minOfOrNull { it.weatherTemperature.tempMin.kelvinToCelsius().toDouble() }
}

fun Double.formatTemperature(): String {
    val tempInCelsius = this.kelvinToCelsius()
    return "$tempInCelsius°"
}

fun List<WeatherForFiveDaysResultDomain>.fetchListWeather(): ImmutableList<Double> {
    val minTemp = this.minOfOrNull { it.weatherTemperature.tempMin.kelvinToCelsius().toDouble() }
        ?: Double.NEGATIVE_INFINITY
    val maxTemp = this.maxOfOrNull { it.weatherTemperature.tempMax.kelvinToCelsius().toDouble() }
        ?: Double.POSITIVE_INFINITY
    val temperatures = this.map { it.weatherTemperature.temperature.kelvinToCelsius().toDouble() }
    val filteredTemperatures = temperatures.filter { it in minTemp..maxTemp }
    return filteredTemperatures.toImmutableList()
}