package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherTemperatureData
import com.example.general.day.domain.models.WeatherTemperatureDomain
import javax.inject.Inject

class WeatherTemperatureDataToDomainMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherTemperatureData, @JvmSuppressWildcards WeatherTemperatureDomain> {
    override fun map(from: WeatherTemperatureData): WeatherTemperatureDomain = from.run {
        WeatherTemperatureDomain(
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin,
            humidity = humidity
        )
    }
}