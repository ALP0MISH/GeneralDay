package com.example.general.day.domain.models

data class WeatherDomain(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
){
    companion object {
        val unknown = WeatherDomain(
            description = String(),
            id = 0,
            main = String(),
            icon = String()
        )
    }
}