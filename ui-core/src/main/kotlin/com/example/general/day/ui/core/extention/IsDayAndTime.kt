package com.example.general.day.ui.core.extention

import java.util.Calendar
import java.util.Date

fun isDayTimeLong(timestamp: Long): Boolean {
    val date = Date(timestamp * 1000)
    val calendar = Calendar.getInstance().apply { time = date }
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    return hour in 6..18
}

fun isDayTimeString(dateTime: String): Boolean {
    val time = dateTime.substring(11, 16)
    val hour = time.substringBefore(':').toInt()
    return hour in 6..18
}