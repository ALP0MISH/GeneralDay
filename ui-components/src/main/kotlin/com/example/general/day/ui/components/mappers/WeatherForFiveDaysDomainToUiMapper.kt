package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class WeatherForFiveDaysDomainToUiMapper @Inject constructor(
    private val cityDataToCityDomain: CityDomainToCityUiMapper,
    private val weatherForFiveDaysResultDataToDomain: WeatherForFiveDaysResultDomainToUiMapper,
) : Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi> {
    override fun map(from: WeatherForFiveDaysDomain): WeatherForFiveDaysUi = from.run {
        WeatherForFiveDaysUi(
            city = cityDataToCityDomain.map(city),
            timeCount = timeCount,
            code = code,
            list = list.map(weatherForFiveDaysResultDataToDomain::map).toImmutableList(),
            message = message
        )
    }
}