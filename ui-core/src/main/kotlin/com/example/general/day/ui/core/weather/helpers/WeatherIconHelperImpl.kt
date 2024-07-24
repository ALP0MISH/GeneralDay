package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import com.example.general.day.ui.core.R
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.DawnDusk
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.Day
import com.example.general.day.ui.core.weather.helpers.TimeOfDayEnum.Night

class WeatherIconHelperImpl(
    private val getWeatherFromString: GetWeatherFromString,
    private val determineTimeOfDay: DetermineTimeOfDay,
) : WeatherIconHelper {

    override fun fetchWeatherIcon(weatherHomeUi: WeatherUi, isDayTime: Boolean): Int {
        return when (getWeatherFromString.getWeatherFromString(weatherHomeUi.main)) {
            WeatherSealedComponent.Snow -> if (isDayTime) R.drawable.snow_light else R.drawable.snow_night
            WeatherSealedComponent.Rain -> if (isDayTime) R.drawable.rain_light else R.drawable.rain_night
            WeatherSealedComponent.Clear -> if (isDayTime) R.drawable.clear_light else R.drawable.clear_night
            WeatherSealedComponent.Cloudy -> if (isDayTime) R.drawable.cloudy else R.drawable.cloudy
            WeatherSealedComponent.LightRain -> if (isDayTime) R.drawable.rain_light else R.drawable.rain_small_night
            WeatherSealedComponent.Mist -> if (isDayTime) R.drawable.mist else R.drawable.mist
            WeatherSealedComponent.Thunderstorm -> if (isDayTime) R.drawable.thunder else R.drawable.thunder
            WeatherSealedComponent.Unknown -> if (isDayTime) R.drawable.light else R.drawable.light
        }
    }

    override fun fetchBackgroundForTimeOfDay(
        timeOfDay: Long,
        weatherSystemInfo: WeatherSystemInformationUi
    ): Int {
        return when (determineTimeOfDay.determineTimeOfDay(timeOfDay, weatherSystemInfo)) {
            Day.name -> R.drawable.light
            DawnDusk.name -> R.drawable.background_duwn_dusk
            Night.name -> R.drawable.background_dark
            else -> R.drawable.light
        }
    }
}