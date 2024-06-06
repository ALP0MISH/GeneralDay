package com.example.general.day.data.local.models

data class WeatherForFiveDaysLocal(
    val localCity: CityLocal,
    val timeCount: Int,
    val code: String,
    val list: List<WeatherForFiveDaysResultLocal>,
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysLocal(
            localCity = CityLocal.unknown,
            code = String(),
            timeCount = -1,
            list = emptyList(),
            message = -1
        )
    }
}