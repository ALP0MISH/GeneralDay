package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.ui.components.models.WeatherTemperatureUi
import javax.inject.Inject

class WeatherTemperatureDomainToUiMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherTemperatureDomain, @JvmSuppressWildcards WeatherTemperatureUi> {
    override fun map(from: WeatherTemperatureDomain): WeatherTemperatureUi = from.run {
        WeatherTemperatureUi(
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin
        )
    }
}