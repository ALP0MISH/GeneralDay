package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.ui.components.models.CloudsHomeUi
import javax.inject.Inject

class CloudsDomainToHomeUiMapper @Inject constructor() : Mapper<CloudsDomain, CloudsHomeUi> {

    override fun map(from: CloudsDomain): CloudsHomeUi = from.run {
        CloudsHomeUi(
            all = all
        )
    }
}