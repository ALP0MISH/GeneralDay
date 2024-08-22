package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.LocalNamesDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.ui.components.models.LocalNamesUi
import com.example.general.day.ui.components.models.SearchWeatherResultUi
import javax.inject.Inject

class SearchWeatherDomainToUiMapper @Inject constructor(
    private val localNameDomainToUiMapper: @JvmSuppressWildcards Mapper<LocalNamesDomain, LocalNamesUi>
) : Mapper<@JvmSuppressWildcards SearchWeatherDomain, @JvmSuppressWildcards SearchWeatherResultUi> {
    override fun map(from: SearchWeatherDomain): SearchWeatherResultUi = from.run {
        SearchWeatherResultUi(
            country = country,
            lat = lat,
            lon = lon,
            name = name,
            state = state,
            localNames = localNameDomainToUiMapper.map(localName)
        )
    }
}