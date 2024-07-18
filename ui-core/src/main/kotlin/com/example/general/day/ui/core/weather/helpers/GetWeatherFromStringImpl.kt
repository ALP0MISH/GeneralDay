package com.example.general.day.ui.core.weather.helpers

class GetWeatherFromStringImpl : GetWeatherFromString {

    override fun getWeatherFromString(weatherString: String): WeatherSealedComponent {
        return when (weatherString) {
            WeatherConditionsEnum.Snow.name -> WeatherSealedComponent.Snow
            WeatherConditionsEnum.Rain.name -> WeatherSealedComponent.Rain
            WeatherConditionsEnum.Clear.name -> WeatherSealedComponent.Clear
            WeatherConditionsEnum.Cloudy.name -> WeatherSealedComponent.Cloudy
            WeatherConditionsEnum.LightRain.name -> WeatherSealedComponent.LightRain
            WeatherConditionsEnum.Mist.name -> WeatherSealedComponent.Mist
            WeatherConditionsEnum.Thunderstorm.name -> WeatherSealedComponent.Thunderstorm
            else -> WeatherSealedComponent.Unknown
        }
    }
}