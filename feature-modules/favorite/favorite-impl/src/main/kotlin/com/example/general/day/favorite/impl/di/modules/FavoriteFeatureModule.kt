package com.example.general.day.favorite.impl.di.modules

import com.example.general.day.favorite.api.FavoriteFeatureUIApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.favorite.impl.ui.FavoriteViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

typealias FavoriteRoute = String
private const val NAMED_FAVORITE = "favorite"

@Module
class FavoriteFeatureModule {

    @Provides
    @Named(NAMED_FAVORITE)
    fun provideFavoriteRoute(): FavoriteRoute = "favorite_screen_route"

    @Provides
    fun provideFavoriteFeatureUIApi(
        @Named(NAMED_FAVORITE) route: FavoriteRoute,
        viewModelFactory: Provider<FavoriteViewModelFactory>
    ): FavoriteFeatureUIApi = FavoriteFeatureImpl(
        route = route,
        viewModelFactory = viewModelFactory
    )
}