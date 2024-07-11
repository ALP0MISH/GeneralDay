package com.example.general.day.home.impl.ui

import com.example.general.day.ui.components.models.ConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.core.factories.DateTimeHelper
import com.example.general.day.ui.core.factories.WeatherIconHelper
import kotlinx.collections.immutable.toImmutableList

private const val CURRENT_TIME_MILLS = 1000

class WeatherDataHelper {

    fun convertWeatherData(
        currentWeatherResult: CurrentWeatherHomeUi,
        weatherForFiveDaysUiModel: List<WeatherForFiveDaysResultHomeUi>
    ): List<ConvertedWeather> {
        val timestamp = weatherForFiveDaysUiModel.firstOrNull()?.time
        val monthAndDay = DateTimeHelper.getMonthAndDay(timestamp?.toLong() ?: 0)
        val timeList = DateTimeHelper.getFormattedTimeList(
            weatherForFiveDaysUiModel.firstOrNull() ?: WeatherForFiveDaysResultHomeUi.unknown
        )
        val time = DateTimeHelper.getFormattedTime(currentWeatherResult)
        val isDayTime = DateTimeHelper.isDayTime(timestamp?.toLong() ?: 0)
        val weatherIconList = WeatherIconHelper.getWeatherIconList(
            weatherForFiveDaysUiModel.firstOrNull() ?: WeatherForFiveDaysResultHomeUi.unknown,
            isDayTime
        )
        val weatherIcon = WeatherIconHelper.getWeatherIcon(currentWeatherResult, isDayTime)
        val temperatureList =
            formatTemperatureList(weatherForFiveDaysUiModel.firstOrNull()?.weatherTemperature?.temperature)
        val temperature = formatTemperature(currentWeatherResult.weatherTemperature.temperature)
        val temperatureMin =
            formatTemperature(weatherForFiveDaysUiModel.firstOrNull()?.weatherTemperature?.tempMin)
        val temperatureMax =
            formatTemperature(weatherForFiveDaysUiModel.firstOrNull()?.weatherTemperature?.tempMax)
        val feelsLikeTemperature =
            formatTemperature(currentWeatherResult.weatherTemperature.feelsLike)
        val currentTime = System.currentTimeMillis() / CURRENT_TIME_MILLS
        val timeOfDay = DateTimeHelper.determineTimeOfDay(currentTime, currentWeatherResult.systemInformation)
        val background = DateTimeHelper.getBackgroundForTimeOfDay(timeOfDay)

        return listOf(
            ConvertedWeather(
                monthAndDay = monthAndDay.toImmutableList(),
                temperature = temperatureList.toImmutableList(),
                temperatureMin = temperatureMin,
                temperatureMax = temperatureMax,
                eachThreeTime = timeList.toImmutableList(),
                feelsLikeTemperature = feelsLikeTemperature,
                weatherIcon = weatherIconList.toImmutableList(),
                weatherBackgroundImage = background,
                currentWeatherIcon = weatherIcon,
                currentTemperature = temperature,
                currentMonthAndDay = time.toString(),
                cityWeather = currentWeatherResult.name
            )
        )
    }

    private fun formatTemperatureList(tempInKelvin: Double?): List<String> {
        val tempInCelsius = kelvinToCelsius(tempInKelvin ?: 0.0)
        return listOf("$tempInCelsius°")
    }

    private fun formatTemperature(tempInKelvin: Double?): String {
        val tempInCelsius = kelvinToCelsius(tempInKelvin ?: 0.0)
        return "$tempInCelsius°"
    }

    private fun kelvinToCelsius(kelvin: Double): Int {
        return (kelvin - 273.15).toInt()
    }
}
