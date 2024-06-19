package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherForFiveDaysData
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import javax.inject.Inject

class WeatherForFiveDaysDataToDomainMapper @Inject constructor(
    private val cityDataToCityDomain: CityDataToCityDomainMapper,
    private val weatherForFiveDaysResultDataToDomain: WeatherForFiveDaysResultDataToDomainMapper,
) : Mapper<WeatherForFiveDaysData, WeatherForFiveDaysDomain> {
    override fun map(from: WeatherForFiveDaysData): WeatherForFiveDaysDomain = from.run {
        WeatherForFiveDaysDomain(
            city = cityDataToCityDomain.map(city),
            timeCount = timeCount,
            code = code,
            list = list.map(weatherForFiveDaysResultDataToDomain::map),
            message = message
        )
    }
}