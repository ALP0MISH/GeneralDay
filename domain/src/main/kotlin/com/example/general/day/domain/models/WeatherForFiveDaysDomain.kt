package com.example.general.day.domain.models

data class WeatherForFiveDaysDomain(
    val city: CityDomain,
    val timeCount: Int,
    val code: String,
    val list: List<WeatherForFiveDaysResultDomain>,
    val message: Int
) {
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