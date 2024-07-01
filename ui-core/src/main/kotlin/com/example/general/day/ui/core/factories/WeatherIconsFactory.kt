package com.example.general.day.ui.core.factories

fun getWeatherFromString(weatherString: String): WeatherSealedComponent {
    return when (weatherString) {
        "Snow" -> WeatherSealedComponent.Snow
        "Rain" -> WeatherSealedComponent.Rain
        "Clear" -> WeatherSealedComponent.Clear
        "Cloudy" -> WeatherSealedComponent.Cloudy
        "Thunderstorm" -> WeatherSealedComponent.LightRain
        "Mist" -> WeatherSealedComponent.Mist
        "LightRain" -> WeatherSealedComponent.Thunderstorm
        else -> WeatherSealedComponent.Unknown
    }
}