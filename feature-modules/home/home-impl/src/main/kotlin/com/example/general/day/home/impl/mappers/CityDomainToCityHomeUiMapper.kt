package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.home.impl.models.CityHomeUi
import javax.inject.Inject

class CityDomainToCityHomeUiMapper @Inject constructor(
    private val coordinatesDomainToHomeUi: CoordinatesDomainToHomeUiMapper
) : Mapper<CityDomain, CityHomeUi> {
    override fun map(from: CityDomain): CityHomeUi = from.run {
        CityHomeUi(
            coordinates = coordinatesDomainToHomeUi.map(coordinates),
            country = country,
            id = id,
            name = name,
            sunrise = sunrise,
            sunset = sunset,
        )
    }
}