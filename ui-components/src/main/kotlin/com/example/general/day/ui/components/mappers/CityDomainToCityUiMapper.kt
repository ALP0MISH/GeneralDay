package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.ui.components.models.CityUi
import javax.inject.Inject

class CityDomainToCityUiMapper @Inject constructor(
    private val coordinatesDomainToUi: CoordinatesDomainToUiMapper
) : Mapper<CityDomain, CityUi> {
    override fun map(from: CityDomain): CityUi = from.run {
        CityUi(
            coordinates = coordinatesDomainToUi.map(coordinates),
            country = country,
            id = id,
            name = name,
            sunrise = sunrise,
            sunset = sunset,
        )
    }
}