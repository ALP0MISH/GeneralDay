package com.example.general.day.data.local.shared.pref

interface SharedPrefManager {
    var isDarkTheme: Boolean

    fun getSavedCityName(): String?

    fun saveCityName(cityName: String)
}