package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.ForRainOrSnowData
import com.example.general.day.domain.models.ForRainOrSnowDomain
import javax.inject.Inject

class ForRainOrSnowDataToForRainOrSnowDomainMapper @Inject constructor() :
    Mapper<ForRainOrSnowData, ForRainOrSnowDomain> {
    override fun map(from: ForRainOrSnowData): ForRainOrSnowDomain = from.run {
        ForRainOrSnowDomain(
            hour = hour
        )
    }

}