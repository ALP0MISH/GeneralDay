package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CurrentWeatherLocalData
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import javax.inject.Inject

class CurrentWeatherDomainToCurrentWeatherDataMapper @Inject constructor() :
    Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalData> {
    override fun map(from: CurrentWeatherLocalDomain): CurrentWeatherLocalData = from.run {
        CurrentWeatherLocalData(
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