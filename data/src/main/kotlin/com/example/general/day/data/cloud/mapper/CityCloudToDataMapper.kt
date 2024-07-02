package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CityCloud
import com.example.general.day.data.models.CityData
import javax.inject.Inject

 class CityCloudToDataMapper @Inject constructor(
    private val coordinatesCloudToDomain: CoordinatesCloudToDataMapper
) : Mapper<CityCloud, CityData> {
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