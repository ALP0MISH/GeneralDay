package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.ui.components.models.CityUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject
import javax.inject.Provider

class WeatherForFiveDaysDomainToUiMapper @Inject constructor(
    private val cityDataToCityDomain: @JvmSuppressWildcards Mapper<CityDomain, CityUi>,
    private val weatherForFiveDaysResultDataToDomain: @JvmSuppressWildcards Mapper<WeatherForFiveDaysResultDomain, WeatherForFiveDaysResultUi>,
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysDomain, @JvmSuppressWildcards WeatherForFiveDaysUi> {

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