package com.example.general.day.favorite.impl.ui

import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.CurrentWeatherLocalHomeUi
import com.example.general.day.ui.core.factories.DateTimeHelper
import com.example.general.day.ui.core.factories.WeatherIconHelper

class WeatherHelper {

    fun convertWeatherData(
        currentWeatherResult: CurrentWeatherHomeUi,
    ): CurrentWeatherLocalHomeUi {
        val timestamp = currentWeatherResult.time
        val isDayTime = DateTimeHelper.isDayTime(timestamp.toLong())
        val weatherIcon = WeatherIconHelper.getWeatherIcon(currentWeatherResult, isDayTime)
        val temperature = formatTemperature(currentWeatherResult.weatherTemperature.temperature)
        val temperatureMin = formatTemperature(currentWeatherResult.weatherTemperature.tempMin)
        val temperatureMax = formatTemperature(currentWeatherResult.weatherTemperature.tempMax)
        val feelsLikeTemperature =
            formatTemperature(currentWeatherResult.weatherTemperature.feelsLike)

        return CurrentWeatherLocalHomeUi(
            id = currentWeatherResult.id,
            code = currentWeatherResult.cod,
            lat = currentWeatherResult.coordinates.lat,
            lon = currentWeatherResult.coordinates.lon,
            feelsLike = feelsLikeTemperature,
            temperature = temperature,
            tempMax = temperatureMax,
            tempMin = temperatureMin,
            cityName = currentWeatherResult.name,
            weatherIcon = weatherIcon
        )
    }

    private fun formatTemperature(tempInKelvin: Double?): String {
        val tempInCelsius = kelvinToCelsius(tempInKelvin ?: 0.0)
        return "$tempInCelsius°"
    }

    private fun kelvinToCelsius(kelvin: Double): Int {
        return (kelvin - 273.15).toInt()
    }
}