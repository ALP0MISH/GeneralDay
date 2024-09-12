package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CityCloud
import com.example.general.day.data.cloud.models.CoordinatesCloud
import com.example.general.day.data.models.CityData
import com.example.general.day.data.models.CoordinatesData
import javax.inject.Inject

class CityCloudToDataMapper @Inject constructor(
    private val coordinatesCloudToDomain: @JvmSuppressWildcards Mapper<CoordinatesCloud, CoordinatesData>
) : Mapper<@JvmSuppressWildcards CityCloud, @JvmSuppressWildcards CityData> {
    override fun map(from: CityCloud): CityData = from.run {
        CityData(
            coordinates = coordinatesCloudToDomain.map(coordinates),
            country = country,
            id = id,
            name = name,
            sunrise = sunrise,
            sunset = sunset,
        )
    }
}