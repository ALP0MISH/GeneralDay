package com.example.general.day.favorite.impl.di.modules

import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.favorite.api.FavoriteFeatureUIApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

typealias FavoriteRoute = String

@Module
class FavoriteFeatureModule {

    @Provides
    @Named("favorite")
    fun provideFavoriteRoute(): FavoriteRoute = "favorite_screen_route"

    @Provides
    fun provideFavoriteFeatureUIApi(
        @Named("favorite") route: FavoriteRoute,
        viewModelFactory: DaggerViewModelFactory
    ): FavoriteFeatureUIApi = FavoriteFeatureImpl(
        route = route,
        viewModelFactory = viewModelFactory
    )
}