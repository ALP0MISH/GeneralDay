package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CloudsData
import com.example.general.day.domain.models.CloudsDomain
import javax.inject.Inject

class CloudsDataToDomainMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards CloudsData, @JvmSuppressWildcards CloudsDomain> {
    override fun map(from: CloudsData): CloudsDomain = from.run {
        CloudsDomain(
            all = all
        )
    }
}