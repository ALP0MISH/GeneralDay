package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.models.WindUi
import javax.inject.Inject

class WindDomainToUIMapper @Inject constructor() : Mapper<WindDomain, WindUi> {
    override fun map(from: WindDomain): WindUi = from.run {
        WindUi(
            degrees = degrees,
            speed = speed
        )
    }
}