package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.LocalNamesDomain
import com.example.general.day.ui.components.models.LocalNamesUi
import javax.inject.Inject

class LocalNameDomainToUiMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards LocalNamesDomain, @JvmSuppressWildcards LocalNamesUi> {
    override fun map(from: LocalNamesDomain): LocalNamesUi = from.run {
        LocalNamesUi(
            ru = ru
        )
    }
}