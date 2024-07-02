package com.example.general.day.home.impl.ui

import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.core.factories.WeatherSealedComponent


object WeatherIconHelper {

    fun getWeatherIconList(
        weatherForFiveDaysUiModel: WeatherForFiveDaysResultHomeUi,
        isDayTime: Boolean
    ): List<Int> {
        val weatherIcon =
            getWeatherFromString(weatherForFiveDaysUiModel.weather.firstOrNull()?.main ?: String())
        val icon = when (weatherIcon) {
            WeatherSealedComponent.Snow -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Rain -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Clear -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Cloudy -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.LightRain -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Mist -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Thunderstorm -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Unknown -> if (isDayTime) drawable.light else drawable.light
        }
        return listOf(icon)
    }

    fun getWeatherIcon(
        currentWeatherResult: CurrentWeatherHomeUi,
        isDayTime: Boolean
    ): Int {
        val weatherIcon =
            getWeatherFromString(currentWeatherResult.weather.firstOrNull()?.main ?: String())
        return when (weatherIcon) {
            WeatherSealedComponent.Snow -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Rain -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Clear -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Cloudy -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.LightRain -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Mist -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Thunderstorm -> if (isDayTime) drawable.light else drawable.light
            WeatherSealedComponent.Unknown -> if (isDayTime) drawable.light else drawable.light
        }
    }

    private fun getWeatherFromString(weatherString: String): WeatherSealedComponent {
        return when (weatherString) {
            "Snow" -> WeatherSealedComponent.Snow
            "Rain" -> WeatherSealedComponent.Rain
            "Clear" -> WeatherSealedComponent.Clear
            "Cloudy" -> WeatherSealedComponent.Cloudy
            "LightRain" -> WeatherSealedComponent.LightRain
            "Mist" -> WeatherSealedComponent.Mist
            "Thunderstorm" -> WeatherSealedComponent.Thunderstorm
            else -> WeatherSealedComponent.Unknown
        }
    }
}
