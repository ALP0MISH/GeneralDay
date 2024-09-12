package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WindCloud
import com.example.general.day.data.models.WindData
import javax.inject.Inject

class WindCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WindCloud, @JvmSuppressWildcards WindData> {
    override fun map(from: WindCloud): WindData = from.run {
        WindData(
            degrees = degrees,
            speed = speed
        )
    }
}