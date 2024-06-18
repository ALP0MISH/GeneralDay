package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherData
import com.example.general.day.domain.models.WeatherDomain
import javax.inject.Inject

class WeatherDataToDomainMapper @Inject constructor() : Mapper<WeatherData, WeatherDomain> {
    override fun map(from: WeatherData): WeatherDomain = from.run {
        WeatherDomain(
            description = description,
            icon = icon,
            id = id,
            main = main,
        )
    }
}