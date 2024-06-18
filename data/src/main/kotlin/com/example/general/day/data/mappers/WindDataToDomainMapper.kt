package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WindData
import com.example.general.day.domain.models.WindDomain
import javax.inject.Inject

class WindDataToDomainMapper @Inject constructor() : Mapper<WindData, WindDomain> {
    override fun map(from: WindData): WindDomain = from.run {
        WindDomain(
            degrees = degrees,
            speed = speed
        )
    }
}