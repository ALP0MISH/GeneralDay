package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherSystemInformationData
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import javax.inject.Inject

class WeatherSystemInformationDataToWeatherSystemInformationDomainMapper @Inject constructor() :
        Mapper<WeatherSystemInformationData, WeatherSystemInformationDomain> {
    override fun map(from: WeatherSystemInformationData): WeatherSystemInformationDomain =
        from.run {
            WeatherSystemInformationDomain(
                partOfDay = partOfDay
            )
        }
}