package com.example.general.day.presentation.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.api.HomeFeatureUiApi
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
        homeFeatureUiApi: HomeFeatureUiApi,
        favoriteFeatureApi: FavoriteFeatureApi,
        mapFeatureApi: MapFeatureApi
    ): DependencyProvider {
        return DependencyProviderImpl(
            homeFeatureUiApi = homeFeatureUiApi,
            favoriteFeatureApi = favoriteFeatureApi,
            mapFeatureApi = mapFeatureApi
        )
    }
}