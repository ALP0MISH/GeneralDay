package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.ui.components.models.CoordinatesUi
import javax.inject.Inject

class CoordinatesDomainToUiMapper @Inject constructor() :
    Mapper<CoordinatesDomain, CoordinatesUi> {
    override fun map(from: CoordinatesDomain): CoordinatesUi = from.run {
       CoordinatesUi(
            lon = lon,
            lat = lat,
        )
    }
}