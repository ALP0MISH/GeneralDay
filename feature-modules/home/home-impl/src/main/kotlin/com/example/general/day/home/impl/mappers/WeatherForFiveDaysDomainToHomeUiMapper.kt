package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.home.impl.models.WeatherForFiveDaysHomeUi
import com.example.general.day.home.impl.models.WeatherForFiveDaysResultHomeUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class WeatherForFiveDaysDomainToHomeUiMapper @Inject constructor(
    private val cityDataToCityDomain: CityDomainToCityHomeUiMapper,
    private val weatherForFiveDaysResultDataToDomain: WeatherForFiveDaysResultDomainToHomeUiMapper,
) : Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysHomeUi> {
    override fun map(from: WeatherForFiveDaysDomain): WeatherForFiveDaysHomeUi = from.run {
        WeatherForFiveDaysHomeUi(
            city = cityDataToCityDomain.map(city),
            timeCount = timeCount,
            code = code,
            list = list.map(weatherForFiveDaysResultDataToDomain::map).toImmutableList(),
            message = message
        )
    }
}