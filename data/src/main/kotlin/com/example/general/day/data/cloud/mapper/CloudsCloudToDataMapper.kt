package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CloudsCloud
import com.example.general.day.data.models.CloudsData
import javax.inject.Inject

class CloudsCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards CloudsCloud, @JvmSuppressWildcards CloudsData> {

    override fun map(from: CloudsCloud): CloudsData = from.run {
        CloudsData(
            all = all
        )
    }
}