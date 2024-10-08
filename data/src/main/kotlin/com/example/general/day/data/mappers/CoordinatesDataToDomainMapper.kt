package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CoordinatesCloud
import com.example.general.day.data.models.CoordinatesData
import com.example.general.day.domain.models.CoordinatesDomain
import javax.inject.Inject

class CoordinatesDataToDomainMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards CoordinatesData, @JvmSuppressWildcards CoordinatesDomain> {
    override fun map(from: CoordinatesData): CoordinatesDomain = from.run {
        CoordinatesDomain(
            lon = lon,
            lat = lat,
        )
    }
}