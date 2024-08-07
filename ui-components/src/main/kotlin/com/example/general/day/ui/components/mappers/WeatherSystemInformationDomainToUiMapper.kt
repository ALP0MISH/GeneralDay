package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import javax.inject.Inject

class WeatherSystemInformationDomainToUiMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherSystemInformationDomain, @JvmSuppressWildcards WeatherSystemInformationUi> {
    override fun map(from: WeatherSystemInformationDomain): WeatherSystemInformationUi =
        from.run {
            WeatherSystemInformationUi(
                partOfDay = partOfDay,
                sunset = sunset,
                sunrise = sunrise,
            )
        }
}