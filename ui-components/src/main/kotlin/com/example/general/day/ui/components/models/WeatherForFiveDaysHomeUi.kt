package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class WeatherForFiveDaysHomeUi(
    val city: CityHomeUi,
    val timeCount: Int,
    val code: String,
    val list: ImmutableList<WeatherForFiveDaysResultHomeUi>,
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysHomeUi(
            city = CityHomeUi.unknown,
            code = String(),
            timeCount = -1,
            list = persistentListOf(WeatherForFiveDaysResultHomeUi.unknown),
            message = -1
        )
    }
}