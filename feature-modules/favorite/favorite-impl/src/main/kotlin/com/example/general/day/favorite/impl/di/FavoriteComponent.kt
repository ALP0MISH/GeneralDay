package com.example.general.day.favorite.impl.di

import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FavoriteScope

@Subcomponent
@FavoriteScope
interface FavoriteComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FavoriteComponent
    }
    fun inject(mapViewModel: FavoriteViewModel)

    fun inject(featureImpl: FavoriteFeatureImpl)
}