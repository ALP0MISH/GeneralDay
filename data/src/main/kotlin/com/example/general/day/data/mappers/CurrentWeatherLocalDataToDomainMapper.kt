package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CurrentWeatherLocalData
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import javax.inject.Inject

class CurrentWeatherLocalDataToDomainMapper @Inject constructor() :
    Mapper<CurrentWeatherLocalData, CurrentWeatherLocalDomain> {
    override fun map(from: CurrentWeatherLocalData): CurrentWeatherLocalDomain = from.run {
        CurrentWeatherLocalDomain(
            id = id,
            code = code,
            lat = lat,
            lon = lon,
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin,
            name = name,
            weatherIcon = weatherIcon,
        )
    }
}