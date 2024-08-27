package com.example.general.day.presentation.di.modules

import com.example.general.day.detail.impl.di.DetailFeatureDependencies
import com.example.general.day.favorite.impl.di.FavoriteFeatureDependencies
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.map.impl.di.MapFeatureDependencies
import com.example.general.day.presentation.feature.depency.DetailFeatureDependenciesImpl
import com.example.general.day.presentation.feature.depency.FavoriteFeatureDependenciesImpl
import com.example.general.day.presentation.feature.depency.HomeFeatureDependenciesImpl
import com.example.general.day.presentation.feature.depency.LocationFeatureDependenciesImpl
import com.example.general.day.presentation.feature.depency.MapFeatureDependenciesImpl
import com.example.general.location.impl.LocationFeatureDependencies
import dagger.Binds
import dagger.Module

@Module
interface FeatureDependencyModule {

    @Binds
    fun bindsHomeFeatureDependencies(
        implementation: HomeFeatureDependenciesImpl
    ): HomeFeatureDependencies

    @Binds
    fun bindsFavoriteFeatureDependencies(
        implementation: FavoriteFeatureDependenciesImpl
    ): FavoriteFeatureDependencies

    @Binds
    fun bindsMapFeatureDependencies(
        implementation: MapFeatureDependenciesImpl
    ): MapFeatureDependencies

    @Binds
    fun bindsLocationFeatureDependencies(
        implementation: LocationFeatureDependenciesImpl
    ): LocationFeatureDependencies

    @Binds
    fun bindsDetailFeatureDependencies(
        implementation: DetailFeatureDependenciesImpl
    ): DetailFeatureDependencies
}