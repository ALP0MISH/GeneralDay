package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import javax.inject.Inject

class CurrentWeatherUiToDomainMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards CurrentWeatherLocalDomain, @JvmSuppressWildcards CurrentWeatherLocalUi> {
    override fun map(from: CurrentWeatherLocalDomain): CurrentWeatherLocalUi = from.run {
        CurrentWeatherLocalUi(
            id = id,
            code = code,
            lat = lat,
            lon = lat,
            feelsLike = feelsLike,
            tempMax = tempMax,
            tempMin = tempMin,
            cityName = name,
            temperature = temperature,
            weatherIcon = weatherIcon,
        )
    }
}