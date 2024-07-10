package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.ui.components.models.CurrentWeatherLocalHomeUi
import javax.inject.Inject

class CurrentWeatherHomeUiToDomainMapper @Inject constructor() :
    Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalHomeUi> {
    override fun map(from: CurrentWeatherLocalDomain): CurrentWeatherLocalHomeUi = from.run {
        CurrentWeatherLocalHomeUi(
            id = id,
            code = code,
            lat = lat,
            lon = lat,
            feelsLike = feelsLike,
            tempMax = tempMax,
            tempMin = tempMin,
            name = name,
            temperature = temperature
        )
    }
}