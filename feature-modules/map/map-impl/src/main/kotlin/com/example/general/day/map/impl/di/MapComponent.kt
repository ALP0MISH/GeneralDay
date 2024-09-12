package com.example.general.day.map.impl.di

import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.map.impl.di.modules.MapFeatureModule
import dagger.Component

@Component(
    modules = [MapFeatureModule::class],
    dependencies = [MapFeatureDependencies::class]
)
interface MapComponent : MapFeatureApi {

    companion object {
        fun initAndGet(dependencies: MapFeatureDependencies): MapComponent =
            DaggerMapComponent.builder()
                .mapFeatureDependencies(dependencies)
                .build()
    }
}