package com.example.general.day.data.local.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.local.models.CurrentWeatherLocal
import com.example.general.day.data.models.CurrentWeatherLocalData
import javax.inject.Inject

class CurrentWeatherLocalToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards CurrentWeatherLocal, @JvmSuppressWildcards CurrentWeatherLocalData> {
    override fun map(from: CurrentWeatherLocal): CurrentWeatherLocalData = from.run {
        CurrentWeatherLocalData(
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