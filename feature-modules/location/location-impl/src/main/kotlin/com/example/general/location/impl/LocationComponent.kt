package com.example.general.location.impl

import com.example.general.day.location.api.LocationFeatureApi
import dagger.Component

@Component(
    modules = [
        LocationModule::class,
    ],
    dependencies = [LocationFeatureDependencies::class]
)
interface LocationComponent : LocationFeatureApi {

    companion object {
        fun initAndGet(dependencies: LocationFeatureDependencies): LocationComponent =
            DaggerLocationComponent.builder()
                .locationFeatureDependencies(dependencies)
                .build()
    }
}