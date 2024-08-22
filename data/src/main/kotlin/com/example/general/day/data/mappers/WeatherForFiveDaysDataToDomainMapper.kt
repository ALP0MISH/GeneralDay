package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CityData
import com.example.general.day.data.models.WeatherForFiveDaysData
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import javax.inject.Inject

class WeatherForFiveDaysDataToDomainMapper @Inject constructor(
    private val cityDataToCityDomain: @JvmSuppressWildcards Mapper<CityData, CityDomain>,
    private val weatherForFiveDaysResultDataToDomain: @JvmSuppressWildcards Mapper<WeatherForFiveDaysResultData, WeatherForFiveDaysResultDomain>,
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysData, @JvmSuppressWildcards WeatherForFiveDaysDomain> {

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