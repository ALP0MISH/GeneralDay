package com.example.general.day.map.impl.ui

import com.example.general.day.map.impl.ui.components.ZoneClusterItem
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.model.polygonOptions

class MapWeatherHelper {

    fun convertWeatherData(
        currentWeatherResult: CurrentWeatherHomeUi,
        latitude: Double,
        longitude: Double
    ): ZoneClusterItem {
//        val timestamp = currentWeatherResult.time
//        val isDayTime = DateTimeHelper.isDayTime(timestamp.toLong())
//        val weatherIcon = WeatherIconHelper.getWeatherIcon(currentWeatherResult, isDayTime)
//        val temperatureMin = formatTemperature(currentWeatherResult.weatherTemperature.tempMin)
//        val temperatureMax = formatTemperature(currentWeatherResult.weatherTemperature.tempMax)

        return ZoneClusterItem(
            id = currentWeatherResult.id.toString(),
            title = currentWeatherResult.name,
            icon = 0,
            polygonOptions = polygonOptions {
                add(LatLng(latitude, longitude))
            },
            snippet = "",
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