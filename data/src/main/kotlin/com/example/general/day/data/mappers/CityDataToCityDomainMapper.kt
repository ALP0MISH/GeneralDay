package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CityData
import com.example.general.day.domain.models.CityDomain
import javax.inject.Inject

class CityDataToCityDomainMapper @Inject constructor(
    private val coordinatesDataToDomain: CoordinatesDataToDomainMapper
) : Mapper<CityData, CityDomain> {
    override fun map(from: CityData): CityDomain = from.run {
        CityDomain(
            coordinates = coordinatesDataToDomain.map(coordinates),
            country = country,
            id = id,
            name = name,
            sunrise = sunrise,
            sunset = sunset,
        )
    }
}