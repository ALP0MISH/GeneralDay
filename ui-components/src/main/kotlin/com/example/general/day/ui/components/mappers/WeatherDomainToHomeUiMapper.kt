package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.ui.components.models.WeatherHomeUi
import javax.inject.Inject

class WeatherDomainToHomeUiMapper @Inject constructor() : Mapper<WeatherDomain, WeatherHomeUi> {
    override fun map(from: WeatherDomain): WeatherHomeUi = from.run {
        WeatherHomeUi(
            description = description,
            icon = icon,
            id = id,
            main = main,
        )
    }
}