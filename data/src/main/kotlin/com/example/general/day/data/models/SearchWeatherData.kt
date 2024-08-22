package com.example.general.day.data.models

data class SearchWeatherData(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String,
    val localNames: LocalNamesData
)