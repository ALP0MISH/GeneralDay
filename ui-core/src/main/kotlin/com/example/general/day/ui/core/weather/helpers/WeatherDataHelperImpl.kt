package com.example.general.day.ui.core.weather.helpers

import android.util.Log
import com.example.general.day.ui.components.models.ConvertedWeatherForFiveDaysUI
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.components.models.WeatherUi
import java.util.UUID
import javax.inject.Inject

class WeatherDataHelperImpl @Inject constructor(
    private val weatherIconHelper: WeatherIconHelper,
    private val determineTimeOfDay: DetermineTimeOfDay,
) : WeatherDataHelper {

    override fun currentConvertedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentConvertedWeather {
        return CurrentConvertedWeather(
            feelsLikeTemperature = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
            weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(
                currentWeatherResult.time.toLong(),
                currentWeatherResult.systemInformation
            ),
            currentWeatherIcon = weatherIconHelper.fetchWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
            ),
            currentTemperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
            currentMonthAndDay = currentWeatherResult.time.toLong().getMonthAndDay(),
            cityName = currentWeatherResult.name,
        )
    }


    override fun convertedWeatherForFiveDays(weatherForFiveDaysResultUi: WeatherForFiveDaysUi): List<ConvertedWeatherForFiveDaysUI> {
        return determineTimeOfDay.getUniqueDatesWithForecasts(weatherForFiveDaysResultUi.list)
            .firstOrNull()?.second?.map { weather ->
                Log.d("AAA", "eachThreeTime = ${weather.time}")
                ConvertedWeatherForFiveDaysUI(
                    feelsLikeTemperature = weather.weatherTemperature.feelsLike.formatTemperature(),
                    weatherIcon = weatherIconHelper.fetchWeatherIcon(
                        weather.weather.firstOrNull() ?: WeatherUi.unknown,
                        determineTimeOfDay.isDayOrNight(weather.time.toLong())
                    ),
                    temperature = weather.weatherTemperature.temperature.formatTemperature(),
                    temperatureMax = weather.weatherTemperature.tempMax.formatTemperature(),
                    temperatureMin = weather.weatherTemperature.tempMin.formatTemperature(),
                    dayMonthAndWeek = determineTimeOfDay.getUniqueDatesWithForecasts(
                        weatherForFiveDaysResultUi.list
                    ).firstOrNull()?.first ?: String(),
                    eachThreeTime = weather.time.toString(),
                )
            } ?: listOf()
    }

    override fun convertSavedWeather(currentWeatherResult: CurrentWeatherUi): CurrentWeatherLocalUi {
        return CurrentWeatherLocalUi(
            id = UUID.randomUUID().toString(),
            code = currentWeatherResult.cod,
            lat = currentWeatherResult.coordinates.lat,
            lon = currentWeatherResult.coordinates.lon,
            feelsLike = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
            temperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
            tempMax = currentWeatherResult.weatherTemperature.tempMax.formatTemperature(),
            tempMin = currentWeatherResult.weatherTemperature.tempMin.formatTemperature(),
            cityName = currentWeatherResult.name,
            weatherIcon = weatherIconHelper.fetchWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
            ),
        )
    }
}