package com.example.general.day.home.impl.ui.di

import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.modules.HomeFeatureModule
import dagger.Component

@Component(
    modules = [HomeFeatureModule::class],
    dependencies = [HomeFeatureDependencies::class]
)
interface HomeComponent : HomeFeatureApi {

    companion object {
        fun initAndGet(dependencies: HomeFeatureDependencies): HomeComponent =
            DaggerHomeComponent.builder()
                .homeFeatureDependencies(dependencies)
                .build()
    }
}