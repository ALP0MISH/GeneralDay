package com.example.general.day.domain.models

import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

data class WeatherForFiveDaysDomain(
    val city: CityDomain,
    val timeCount: Int,
    val code: String,
    val list: List<WeatherForFiveDaysResultDomain>,
    val message: Int
) {
    fun groupByDate() = list.groupBy {
        with(Calendar.getInstance()) {
            time = Date(TimeUnit.SECONDS.toMillis(it.time))
            get(Calendar.DATE)
        }
    }
    companion object {
        val unknown = WeatherForFiveDaysDomain(
            city = CityDomain.unknown,
            code = String(),
            timeCount = -1,
            list = emptyList(),
            message = -1
        )
    }
}