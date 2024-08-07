package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.SearchWeatherData
import com.example.general.day.domain.models.SearchWeatherDomain
import javax.inject.Inject

class SearchWeatherDataToDomainMapper @Inject constructor(
) : Mapper<@JvmSuppressWildcards SearchWeatherData, @JvmSuppressWildcards SearchWeatherDomain> {
    override fun map(from: SearchWeatherData): SearchWeatherDomain = from.run {
        SearchWeatherDomain(
            country = country,
            lat = lat,
            lon = lon,
            name = name,
            state = state,
        )
    }
}