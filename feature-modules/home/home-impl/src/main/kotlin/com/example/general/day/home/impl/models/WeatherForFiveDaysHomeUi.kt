package com.example.general.day.home.impl.models

data class WeatherForFiveDaysHomeUi(
    val city: CityHomeUi,
    val timeCount: Int,
    val code: String,
    val list: List<WeatherForFiveDaysResultHomeUi>,
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysHomeUi(
            city = CityHomeUi.unknown,
            code = String(),
            timeCount = -1,
            list = emptyList(),
            message = -1
        )
    }
}