package com.example.general.day.presentation.di.modules

import com.example.general.day.core.FeatureApi
import com.example.general.day.detail.api.DetailFeatureApi
import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.presentation.feature.depency.FeatureApiProvider
import com.example.general.day.presentation.feature.depency.FeatureApiProviderImpl
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Qualifier

@Qualifier
annotation class FeatureApiSet

@Module
class FeatureApiModule {

    @Provides
    fun provideLocationApi(
        locationFeatureApi: LocationFeatureApi
    ): LocationTrackerManager = locationFeatureApi.provideLocationTrackerManager()

    @IntoSet
    @Provides
    @FeatureApiSet
    fun providesHomeFeatureApi(
        homeFeatureApi: HomeFeatureApi,
    ): FeatureApi = homeFeatureApi.provideHomeFeatureUiApi()

    @IntoSet
    @Provides
    @FeatureApiSet
    fun providesFavoriteFeatureApi(
        favoriteFeatureApi: FavoriteFeatureApi,
    ): FeatureApi = favoriteFeatureApi.provideFavoriteFeatureUiApi()

    @IntoSet
    @Provides
    @FeatureApiSet
    fun providesMapFeatureApi(
        mapFeatureApi: MapFeatureApi,
    ): FeatureApi = mapFeatureApi.provideMapFeatureUiApi()

    @IntoSet
    @Provides
    @FeatureApiSet
    fun providesDetailFeatureApi(
        detailFeatureApi: DetailFeatureApi
    ): FeatureApi = detailFeatureApi.provideDetailFeatureUiApi()

    @Provides
    fun providesFeatureApiProvider(
        featureApi: Set<@JvmSuppressWildcards FeatureApi>
    ): FeatureApiProvider = FeatureApiProviderImpl(
        featureApi = featureApi
    )
}