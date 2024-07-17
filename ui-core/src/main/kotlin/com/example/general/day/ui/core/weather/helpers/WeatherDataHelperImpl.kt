package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.ConvertedWeatherForFiveDays
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.components.models.WeatherHomeUi

class WeatherDataHelperImpl(
    private val weatherIconHelper: WeatherIconHelper,
    private val determineTimeOfDay: DetermineTimeOfDay,
) : WeatherDataHelper {

    override fun currentConvertedWeather(
        currentWeatherResult: CurrentWeatherHomeUi,
    ): CurrentConvertedWeather {
        return CurrentConvertedWeather(
            feelsLikeTemperature = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
            weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(
                currentWeatherResult.time.toLong(),
                currentWeatherResult.systemInformation
            ),
            currentWeatherIcon = weatherIconHelper.fetchWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherHomeUi.unknown,
                determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
            ),
            currentTemperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
            currentMonthAndDay = currentWeatherResult.time.toLong().getMonthAndDay(),
            cityName = currentWeatherResult.name
        )
    }

    override fun convertedWeatherForFiveDays(weatherForFiveDaysResultUi: WeatherForFiveDaysResultHomeUi): List<ConvertedWeatherForFiveDays> {
        return listOf(
            ConvertedWeatherForFiveDays(
                feelsLikeTemperature = weatherForFiveDaysResultUi.weatherTemperature.feelsLike.formatTemperature(),
                weatherIcon = weatherIconHelper.fetchWeatherIcon(
                    weatherForFiveDaysResultUi.weather.firstOrNull() ?: WeatherHomeUi.unknown,
                    determineTimeOfDay.isDayOrNight(weatherForFiveDaysResultUi.time.toLong())
                ),
                temperature = weatherForFiveDaysResultUi.weatherTemperature.temperature.formatTemperature(),
                dayMonthAndWeek = weatherForFiveDaysResultUi.time.toLong().getMonthAndDay(),
                temperatureMax = weatherForFiveDaysResultUi.weatherTemperature.tempMax.formatTemperature(),
                temperatureMin = weatherForFiveDaysResultUi.weatherTemperature.tempMin.formatTemperature(),
                eachThreeTime = weatherForFiveDaysResultUi.timeText.getFormattedTime(),
            )
        )
    }
}