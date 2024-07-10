package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.ui.components.models.ForRainOrSnowHomeUi
import javax.inject.Inject

class ForRainOrSnowDomainToHomeUiMapper @Inject constructor() :
    Mapper<ForRainOrSnowDomain, ForRainOrSnowHomeUi> {
    override fun map(from: ForRainOrSnowDomain): ForRainOrSnowHomeUi = from.run {
        ForRainOrSnowHomeUi(
            hour = hour
        )
    }

}