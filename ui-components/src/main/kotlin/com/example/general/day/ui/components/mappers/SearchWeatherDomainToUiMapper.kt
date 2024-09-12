package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.LocalNamesDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.ui.components.models.LocalNamesUi
import com.example.general.day.ui.components.models.SearchWeatherUi
import javax.inject.Inject

class SearchWeatherDomainToUiMapper @Inject constructor(
    private val localNameDomainToUiMapper: @JvmSuppressWildcards Mapper<LocalNamesDomain, LocalNamesUi>
) : Mapper<@JvmSuppressWildcards SearchWeatherDomain, @JvmSuppressWildcards SearchWeatherUi> {
    override fun map(from: SearchWeatherDomain): SearchWeatherUi = from.run {
        SearchWeatherUi(
            country = country,
            lat = lat,
            lon = lon,
            name = name,
            state = state,
            localName = localNameDomainToUiMapper.map(localName)
        )
    }
}