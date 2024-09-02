package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

@Immutable
data class WeatherForFiveDaysUi(
    val city: CityUi,
    val timeCount: Int,
    val code: String,
    val list: ImmutableList<WeatherForFiveDaysResultUi>,
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysUi(
            city = CityUi.unknown,
            code = String(),
            timeCount = -1,
            list = persistentListOf(WeatherForFiveDaysResultUi.unknown),
            message = -1
        )
        val preview = WeatherForFiveDaysUi(
            city = CityUi.preview,
            code = "2121",
            timeCount = 23434,
            list = persistentListOf(WeatherForFiveDaysResultUi.unknown),
            message = 32323
        )
    }
}