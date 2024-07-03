package com.example.general.day.ui.core.extention

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("SimpleDateFormat")
fun getMonthAndDayOfWeekLong(timestamp: Long): String {
    val date = Date(timestamp * 1000)
    val dayFormat = SimpleDateFormat("d", Locale("ru"))
    val monthFormat = SimpleDateFormat("MMMM", Locale("ru"))
    val dayOfWeekFormat = SimpleDateFormat("EE", Locale("ru"))
    val day = dayFormat.format(date)
    val month = monthFormat.format(date)
    val dayOfWeek = dayOfWeekFormat.format(date)
    return "$day $month, $dayOfWeek"
}

@SuppressLint("SimpleDateFormat")
fun getMonthAndDayOfWeekString(dateTime: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ru"))
    val date = inputFormat.parse(dateTime)
    val outputFormat = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))
    return outputFormat.format(date!!)
}