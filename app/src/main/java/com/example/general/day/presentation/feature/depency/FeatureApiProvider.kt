package com.example.general.day.presentation.feature.depency

import com.example.general.day.core.FeatureApi


interface FeatureApiProvider {

    fun getApi(): List<FeatureApi>
}