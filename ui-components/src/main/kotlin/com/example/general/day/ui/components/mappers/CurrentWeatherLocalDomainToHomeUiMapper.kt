package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.ui.components.models.CurrentWeatherLocalHomeUi
import javax.inject.Inject

class CurrentWeatherLocalDomainToHomeUiMapper @Inject constructor() :
    Mapper<CurrentWeatherLocalHomeUi, CurrentWeatherLocalDomain> {
    override fun map(from: CurrentWeatherLocalHomeUi): CurrentWeatherLocalDomain = from.run {
        CurrentWeatherLocalDomain(
            id = id,
            code = code,
            lat = lat,
            lon = lon,
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin,
            name = cityName,
            weatherIcon = weatherIcon
        )
    }
}