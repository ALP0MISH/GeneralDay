package com.example.general.day.ui.core.weather.helpers

import com.example.general.day.ui.components.models.ConvertedWeatherForFiveDays
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi


interface WeatherDataHelper {

    fun currentConvertedWeather(
        currentWeatherResult: CurrentWeatherHomeUi,
    ): CurrentConvertedWeather

    fun convertedWeatherForFiveDays(
        weatherForFiveDaysResultUi: WeatherForFiveDaysResultHomeUi
    ): List<ConvertedWeatherForFiveDays>
}

