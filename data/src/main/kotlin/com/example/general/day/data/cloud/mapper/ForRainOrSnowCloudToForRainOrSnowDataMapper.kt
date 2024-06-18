package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.ForRainOrSnowCloud
import com.example.general.day.data.models.ForRainOrSnowData
import javax.inject.Inject

class ForRainOrSnowCloudToForRainOrSnowDataMapper @Inject constructor() :
    Mapper<ForRainOrSnowCloud, ForRainOrSnowData> {
    override fun map(from: ForRainOrSnowCloud): ForRainOrSnowData = from.run {
        ForRainOrSnowData(
            hour = hour
        )
    }

}