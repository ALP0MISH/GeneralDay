package com.example.general.day.ui.core.extention

import com.example.general.day.ui.core.factories.WeatherSealedComponent

fun getWeatherFromString(weatherString: String): WeatherSealedComponent {
    return when (weatherString) {
        "Snow" -> WeatherSealedComponent.Snow
        "Rain" -> WeatherSealedComponent.Rain
        "Clear" -> WeatherSealedComponent.Clear
        "Cloudy" -> WeatherSealedComponent.Cloudy
        "LightRain" -> WeatherSealedComponent.LightRain
        "Mist" -> WeatherSealedComponent.Mist
        "Thunderstorm" -> WeatherSealedComponent.Thunderstorm
        else -> WeatherSealedComponent.Clear
    }
}