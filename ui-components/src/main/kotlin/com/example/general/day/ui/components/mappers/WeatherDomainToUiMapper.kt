package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.ui.components.models.WeatherUi
import javax.inject.Inject

class WeatherDomainToUiMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherDomain, @JvmSuppressWildcards WeatherUi> {
    override fun map(from: WeatherDomain): WeatherUi = from.run {
        WeatherUi(
            description = description,
            icon = icon,
            id = id,
            main = main,
        )
    }
}