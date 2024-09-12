package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForDetail
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.core.utils.ZoneClusterItem
import com.google.android.gms.maps.model.LatLng

interface WeatherDataConverter {

    fun toCurrentConvertedWeather(currentWeatherResult: CurrentWeatherUi): CurrentConvertedWeather

    fun toLocalWeather(currentWeatherResult: CurrentWeatherUi): CurrentWeatherLocalUi

    fun toZoneClusterItem(
        currentWeatherResult: CurrentWeatherUi,
        weatherForFiveDaysUi: WeatherForFiveDaysResultUi,
        latLng: LatLng
    ): ZoneClusterItem

    fun toDetailedWeather(
        currentWeatherResult: CurrentWeatherUi,
        weatherForFiveDaysUi: WeatherForFiveDaysResultUi
    ): WeatherForDetail
}