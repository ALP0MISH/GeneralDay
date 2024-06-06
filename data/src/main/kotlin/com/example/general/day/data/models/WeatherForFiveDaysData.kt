package com.example.general.day.data.models

data class WeatherForFiveDaysData(
    val city: CityData,
    val timeCount: Int,
    val code: String,
    val list: List<WeatherForFiveDaysResultData>,
    val message: Int
) {
    companion object {
        val unknown = WeatherForFiveDaysData(
            city = CityData.unknown,
            code = String(),
            timeCount = -1,
            list = emptyList(),
            message = -1
        )
    }
}