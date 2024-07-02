package com.example.general.day.ui.core.factories

sealed class WeatherSealedComponent {
    data object Snow : WeatherSealedComponent()
    data object Rain : WeatherSealedComponent()
    data object Clear : WeatherSealedComponent()
    data object Cloudy : WeatherSealedComponent()
    data object Thunderstorm : WeatherSealedComponent()
    data object Mist : WeatherSealedComponent()
    data object LightRain : WeatherSealedComponent()
    data object Unknown : WeatherSealedComponent()
}