package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.ForRainOrSnowCloud
import com.example.general.day.data.models.ForRainOrSnowData
import javax.inject.Inject

class ForRainOrSnowCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards ForRainOrSnowCloud?, @JvmSuppressWildcards ForRainOrSnowData> {
    override fun map(from: ForRainOrSnowCloud?): ForRainOrSnowData = from?.let {
        ForRainOrSnowData(
            hour = it.hour ?: 0.0
        )
    } ?: ForRainOrSnowData(0.0)
}