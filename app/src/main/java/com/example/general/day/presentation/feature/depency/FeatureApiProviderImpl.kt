package com.example.general.day.presentation.feature.depency

import com.example.general.day.core.FeatureApi
import javax.inject.Inject

class FeatureApiProviderImpl @Inject constructor(
    private val featureApi: Set<@JvmSuppressWildcards FeatureApi>
) : FeatureApiProvider {

    override fun getApi(): List<FeatureApi> {
        return featureApi.toList()
    }
}