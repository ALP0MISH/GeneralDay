package com.example.general.day.detail.impl.di

import com.example.general.day.detail.api.DetailFeatureApi
import com.example.general.day.detail.impl.di.modules.DetailFeatureModule
import dagger.Component

@Component(
    modules = [DetailFeatureModule::class],
    dependencies = [DetailFeatureDependencies::class]
)
interface DetailComponent : DetailFeatureApi {

    companion object {
        fun initAndGet(dependencies: DetailFeatureDependencies): DetailComponent =
            DaggerDetailComponent.builder()
                .detailFeatureDependencies(dependencies)
                .build()
    }
}