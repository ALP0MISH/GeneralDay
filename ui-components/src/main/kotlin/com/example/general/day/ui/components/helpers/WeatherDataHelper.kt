package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForDetail
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.core.utils.ZoneClusterItem
import com.google.android.gms.maps.model.LatLng


interface WeatherDataHelper {

    fun currentConvertedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentConvertedWeather

    fun convertSavedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentWeatherLocalUi

    fun convertMapWeatherData(
        currentWeatherResult: CurrentWeatherUi,
        latLng: LatLng
    ): ZoneClusterItem

    fun convertWeatherForFiveDays(
        currentWeatherResult: CurrentWeatherUi,
        weatherForFiveDaysUi: WeatherForFiveDaysResultUi
    ): WeatherForDetail
}