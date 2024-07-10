package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.models.WindHomeUi
import javax.inject.Inject

class WindDomainToHomeUIMapper @Inject constructor() : Mapper<WindDomain, WindHomeUi> {
    override fun map(from: WindDomain): WindHomeUi = from.run {
        WindHomeUi(
            degrees = degrees,
            speed = speed
        )
    }
}