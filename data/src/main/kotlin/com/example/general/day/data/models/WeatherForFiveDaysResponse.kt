package com.example.general.day.data.models

import com.example.general.day.data.local.models.LocalCity
import com.example.general.day.data.local.models.LocalWeatherForFiveDaysResponse
import com.example.general.day.data.local.models.LocalWeatherForFiveDaysResultCloud

data class WeatherForFiveDaysResponse(
    val localCity: LocalCity,
    val cnt: Int,
    val cod: String,
    val list: List<LocalWeatherForFiveDaysResultCloud>,
    val message: Int
) {
    companion object {
        val unknown = LocalWeatherForFiveDaysResponse(
            localCity = City.unknown,
            cod = String(),
            cnt = -1,
            list = emptyList(),
            message = -1
        )
    }
}