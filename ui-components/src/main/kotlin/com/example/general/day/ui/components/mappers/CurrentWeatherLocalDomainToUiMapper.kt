package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import javax.inject.Inject

class CurrentWeatherLocalDomainToUiMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards CurrentWeatherLocalUi, @JvmSuppressWildcards CurrentWeatherLocalDomain> {
    override fun map(from: CurrentWeatherLocalUi): CurrentWeatherLocalDomain = from.run {
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