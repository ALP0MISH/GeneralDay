package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.ConvertedWeatherForFiveDaysUI
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi


interface WeatherDataHelper {

    fun currentConvertedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentConvertedWeather

    fun convertedWeatherForFiveDays(
        weatherForFiveDaysResultUi: WeatherForFiveDaysUi
    ): List<ConvertedWeatherForFiveDaysUI>

    fun convertSavedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentWeatherLocalUi
}