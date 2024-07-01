package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.home.impl.models.CoordinatesHomeUi
import javax.inject.Inject

class CoordinatesDomainToHomeUiMapper @Inject constructor() :
    Mapper<CoordinatesDomain, CoordinatesHomeUi> {
    override fun map(from: CoordinatesDomain): CoordinatesHomeUi = from.run {
        CoordinatesHomeUi(
            lon = lon,
            lat = lat,
        )
    }
}