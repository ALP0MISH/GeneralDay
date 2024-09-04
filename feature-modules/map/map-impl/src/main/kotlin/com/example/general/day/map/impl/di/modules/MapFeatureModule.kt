package com.example.general.day.map.impl.di.modules

import com.example.general.day.map.api.MapFeatureUiApi
import com.example.general.day.map.impl.MapFeatureImpl
import com.example.general.day.map.impl.ui.MapViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

typealias MapRoute = String

@Module
class MapFeatureModule {

    @Provides
    fun provideMapRoute(): MapRoute = "map_screen_route"

    @Provides
    fun provideMapFeatureUiApi(
        route: MapRoute,
        viewModelProvider: Provider<MapViewModelFactory>
    ): MapFeatureUiApi = MapFeatureImpl(
        route = route,
        viewModelProvider = viewModelProvider
    )
}