package com.example.general.day.presentation.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.di.HomeComponent
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.map.impl.MapFeatureImpl
import com.example.general.day.presentation.feature.depency.DependencyProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DependencyProviderModule {

    @Provides
    @Singleton
    fun provideFavoriteFeatureApi(): FavoriteFeatureApi {
        return FavoriteFeatureImpl()
    }

    @Provides
    @Singleton
    fun provideMapFeatureApi(): MapFeatureApi {
        return MapFeatureImpl()
    }

    @Provides
    @Singleton
    fun provideDependencyProvider(
        homeFeatureApi: HomeFeatureApi,
        favoriteFeatureApi: FavoriteFeatureApi,
        mapFeatureApi: MapFeatureApi
    ): DependencyProvider {
        return DependencyProviderImpl(
            homeFeatureApi = homeFeatureApi,
            favoriteFeatureApi = favoriteFeatureApi,
            mapFeatureApi = mapFeatureApi
        )
    }
}