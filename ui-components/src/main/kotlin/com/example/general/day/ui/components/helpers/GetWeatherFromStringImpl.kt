package com.example.general.day.ui.components.helpers

import javax.inject.Inject

class GetWeatherFromStringImpl @Inject constructor() : GetWeatherFromString {

    override fun getWeatherFromString(weatherString: String): WeatherSealedComponent {
        return when (weatherString) {
            WeatherCondition.Snow.name -> WeatherSealedComponent.Snow
            WeatherCondition.Rain.name -> WeatherSealedComponent.Rain
            WeatherCondition.Clear.name -> WeatherSealedComponent.Clear
            WeatherCondition.Clouds.name -> WeatherSealedComponent.Cloudy
            WeatherCondition.LightRain.name -> WeatherSealedComponent.LightRain
            WeatherCondition.Mist.name -> WeatherSealedComponent.Mist
            WeatherCondition.Thunderstorm.name -> WeatherSealedComponent.Thunderstorm
            else -> WeatherSealedComponent.Unknown
        }
    }
}