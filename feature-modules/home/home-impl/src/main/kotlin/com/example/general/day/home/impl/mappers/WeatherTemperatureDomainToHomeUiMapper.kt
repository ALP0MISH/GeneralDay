package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.home.impl.models.WeatherTemperatureHomeUi
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