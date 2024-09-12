package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.LocalNamesCloud
import com.example.general.day.data.models.LocalNamesData
import javax.inject.Inject

class LocalNameCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards LocalNamesCloud?, @JvmSuppressWildcards LocalNamesData> {
    override fun map(from: LocalNamesCloud?): LocalNamesData = from?.run {
        LocalNamesData(
            ru = ru ?: ""
        )
    } ?: LocalNamesData(ru = String())
}