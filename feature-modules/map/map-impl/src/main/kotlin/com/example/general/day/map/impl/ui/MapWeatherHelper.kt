package com.example.general.day.map.impl.ui

import com.example.general.day.map.impl.ui.components.ZoneClusterItem
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.CurrentWeatherLocalHomeUi
import com.example.general.day.ui.core.factories.DateTimeHelper
import com.example.general.day.ui.core.factories.WeatherIconHelper
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.model.polygonOptions

class MapWeatherHelper {

    fun convertWeatherData(
        currentWeatherResult: CurrentWeatherHomeUi,
        latitude: Double,
        longitude: Double
    ): ZoneClusterItem {
        val timestamp = currentWeatherResult.time
        val isDayTime = DateTimeHelper.isDayTime(timestamp.toLong())
        val weatherIcon = WeatherIconHelper.getWeatherIcon(currentWeatherResult, isDayTime)
        val temperatureMin = formatTemperature(currentWeatherResult.weatherTemperature.tempMin)
        val temperatureMax = formatTemperature(currentWeatherResult.weatherTemperature.tempMax)


        return ZoneClusterItem(
            id = currentWeatherResult.id.toString(),
            title = currentWeatherResult.name,
            icon = weatherIcon,
            polygonOptions = polygonOptions {
                add(LatLng(latitude, longitude))
            },
            snippet = "$temperatureMin° $temperatureMax°",
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