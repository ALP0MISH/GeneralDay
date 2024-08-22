package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.LocalNamesData
import com.example.general.day.domain.models.LocalNamesDomain
import javax.inject.Inject

class LocalNameDataToDomainMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards LocalNamesData, @JvmSuppressWildcards LocalNamesDomain> {
    override fun map(from: LocalNamesData): LocalNamesDomain = from.run {
        LocalNamesDomain(
            ru = ru ?: String()
        )
    }
}