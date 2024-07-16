package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.ui.components.models.CloudsUi
import javax.inject.Inject

class CloudsDomainToUiMapper @Inject constructor() : Mapper<CloudsDomain, CloudsUi> {

    override fun map(from: CloudsDomain): CloudsUi = from.run {
        CloudsUi(
            all = all
        )
    }
}