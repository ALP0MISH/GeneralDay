package com.example.general.day.map.impl.di.modules

import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.map.api.MapFeatureUiApi
import com.example.general.day.map.impl.MapFeatureImpl
import dagger.Module
import dagger.Provides

typealias MapRoute = String

@Module
class MapFeatureModule {

    @Provides
    fun provideMapRoute(): MapRoute = "map_screen_route"

    @Provides
    fun provideMapFeatureUiApi(
        route: MapRoute,
        viewModelFactory: DaggerViewModelFactory
    ): MapFeatureUiApi = MapFeatureImpl(
        route = route,
        viewModelFactory = viewModelFactory
    )
}