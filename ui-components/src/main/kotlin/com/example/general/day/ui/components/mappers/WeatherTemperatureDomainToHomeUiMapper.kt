package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.ui.components.models.WeatherTemperatureHomeUi
import javax.inject.Inject

class WeatherTemperatureDomainToHomeUiMapper @Inject constructor() :
    Mapper<WeatherTemperatureDomain, WeatherTemperatureHomeUi> {
    override fun map(from: WeatherTemperatureDomain): WeatherTemperatureHomeUi = from.run {
        WeatherTemperatureHomeUi(
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin
        )
    }
}