package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.ui.components.models.WeatherSystemInformationHomeUi
import javax.inject.Inject

class WeatherSystemInformationDomainToHomeUiMapper @Inject constructor() :
    Mapper<WeatherSystemInformationDomain, WeatherSystemInformationHomeUi> {
    override fun map(from: WeatherSystemInformationDomain): WeatherSystemInformationHomeUi =
        from.run {
            WeatherSystemInformationHomeUi(
                partOfDay = partOfDay,
                sunset = sunset,
                sunrise = sunrise,
            )
        }
}