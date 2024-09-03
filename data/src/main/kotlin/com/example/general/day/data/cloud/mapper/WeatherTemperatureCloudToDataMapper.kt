package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherTemperatureCloud
import com.example.general.day.data.models.WeatherTemperatureData
import javax.inject.Inject

class WeatherTemperatureCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherTemperatureCloud, @JvmSuppressWildcards WeatherTemperatureData> {
    override fun map(from: WeatherTemperatureCloud): WeatherTemperatureData = from.run {
        WeatherTemperatureData(
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin,
            humidity = humidity
        )
    }
}