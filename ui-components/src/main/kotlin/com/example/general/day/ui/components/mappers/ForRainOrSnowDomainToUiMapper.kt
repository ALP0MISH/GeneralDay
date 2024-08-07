package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.ui.components.models.ForRainOrSnowUi
import javax.inject.Inject

class ForRainOrSnowDomainToUiMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards ForRainOrSnowDomain, @JvmSuppressWildcards ForRainOrSnowUi> {
    override fun map(from: ForRainOrSnowDomain): ForRainOrSnowUi = from.run {
        ForRainOrSnowUi(
            hour = hour
        )
    }

}