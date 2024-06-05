package com.example.general.day.data.local.models

import com.example.general.day.data.models.City
import com.example.general.day.data.models.WeatherForFiveDaysResponse

data class LocalWeatherForFiveDaysResponse(
    val localCity: LocalCity,
    val cnt: Int,
    val cod: String,
    val list: List<LocalWeatherForFiveDaysResultCloud>,
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysResponse(
            localCity = City.unknown,
            cod = String(),
            cnt = -1,
            list = emptyList(),
            message = -1
        )
    }
}