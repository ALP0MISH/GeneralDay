package com.example.general.day.favorite.impl.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.di.modules.FavoriteFeatureModule
import dagger.Component

@Component(
    modules = [FavoriteFeatureModule::class],
    dependencies = [FavoriteFeatureDependencies::class]
)
interface FavoriteComponent : FavoriteFeatureApi {

    companion object {
        fun initAndGet(dependencies: FavoriteFeatureDependencies): FavoriteComponent =
            DaggerFavoriteComponent.builder()
                .favoriteFeatureDependencies(dependencies)
                .build()
    }
}