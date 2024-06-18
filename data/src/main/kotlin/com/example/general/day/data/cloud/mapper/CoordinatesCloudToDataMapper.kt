package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CoordinatesCloud
import com.example.general.day.data.models.CoordinatesData
import javax.inject.Inject

class CoordinatesCloudToDataMapper @Inject constructor() :
    Mapper<CoordinatesCloud, CoordinatesData> {
    override fun map(from: CoordinatesCloud): CoordinatesData = from.run {
        CoordinatesData(
            lon = lon,
            lat = lat,
        )
    }
}