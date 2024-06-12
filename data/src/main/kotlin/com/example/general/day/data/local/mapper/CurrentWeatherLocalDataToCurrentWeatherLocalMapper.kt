package com.example.general.day.data.local.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.local.models.CurrentWeatherLocal
import com.example.general.day.data.models.CurrentWeatherLocalData
import javax.inject.Inject

class CurrentWeatherLocalDataToCurrentWeatherLocalMapper @Inject constructor() :
    Mapper<CurrentWeatherLocalData, CurrentWeatherLocal> {
    override fun map(from: CurrentWeatherLocalData): CurrentWeatherLocal = from.run {
        CurrentWeatherLocal(
            id = id,
            code = code,
            lat = lat,
            lon = lon,
            feelsLike = feelsLike,
            temperature = temperature,
            tempMax = tempMax,
            tempMin = tempMin,
            name = name,
        )
    }
}