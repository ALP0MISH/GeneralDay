package com.example.general.day.ui.core.weather.helpers

import javax.inject.Inject

class GetWeatherFromStringImpl @Inject constructor() : GetWeatherFromString {

    override fun getWeatherFromString(weatherString: String): WeatherSealedComponent {
        return when (weatherString) {
            WeatherConditionsEnum.Snow.name -> WeatherSealedComponent.Snow
            WeatherConditionsEnum.Rain.name -> WeatherSealedComponent.Rain
            WeatherConditionsEnum.Clear.name -> WeatherSealedComponent.Clear
            WeatherConditionsEnum.Clouds.name -> WeatherSealedComponent.Cloudy
            WeatherConditionsEnum.LightRain.name -> WeatherSealedComponent.LightRain
            WeatherConditionsEnum.Mist.name -> WeatherSealedComponent.Mist
            WeatherConditionsEnum.Thunderstorm.name -> WeatherSealedComponent.Thunderstorm
            else -> WeatherSealedComponent.Unknown
        }
    }
}