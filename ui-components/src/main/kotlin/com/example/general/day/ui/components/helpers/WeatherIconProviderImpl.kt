package com.example.general.day.ui.components.helpers

import androidx.annotation.DrawableRes
import com.example.general.day.ui.components.helpers.TimeOfDay.DawnDusk
import com.example.general.day.ui.components.helpers.TimeOfDay.Day
import com.example.general.day.ui.components.helpers.TimeOfDay.Night
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.core.R
import javax.inject.Inject

class WeatherIconProviderImpl @Inject constructor(
    private val getWeatherFromString: GetWeatherFromString,
    private val timeOfDayEvaluator: TimeOfDayEvaluator,
) : WeatherIconProvider {

    @DrawableRes
    override fun getWeatherIcon(weatherHomeUi: WeatherUi, isDayTime: Boolean): Int {
        return when (getWeatherFromString.getWeatherFromString(weatherHomeUi.main)) {
            WeatherSealedComponent.Snow -> if (isDayTime) R.drawable.snow_light else R.drawable.snow_night
            WeatherSealedComponent.Rain -> if (isDayTime) R.drawable.rain_light else R.drawable.rain_night
            WeatherSealedComponent.Clear -> if (isDayTime) R.drawable.clear_light else R.drawable.clear_night
            WeatherSealedComponent.Cloudy -> if (isDayTime) R.drawable.cloudy else R.drawable.cloudy
            WeatherSealedComponent.LightRain -> if (isDayTime) R.drawable.rain_light else R.drawable.rain_small_night
            WeatherSealedComponent.Mist -> if (isDayTime) R.drawable.mist else R.drawable.mist
            WeatherSealedComponent.Thunderstorm -> if (isDayTime) R.drawable.thunder else R.drawable.thunder
            WeatherSealedComponent.Clouds -> if (isDayTime) R.drawable.cloudy else R.drawable.cloudy
            WeatherSealedComponent.Unknown -> if (isDayTime) R.drawable.clear_light else R.drawable.clear_night
        }
    }

    @DrawableRes
    override fun getBackgroundForTimeOfDay(timeOfDay: Long): Int {
        return when (timeOfDayEvaluator.determineTimeOfDay(timeOfDay)) {
            Day -> R.drawable.background_image_light
            DawnDusk -> R.drawable.background_duwn_dusk
            Night -> R.drawable.background_dark
        }
    }
}