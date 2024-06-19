package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.home.impl.models.CurrentWeatherLocalHomeUi
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