package com.example.general.day.presentation.di.modules

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.di.FavoriteComponentHolder
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.HomeComponentHolder
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.map.impl.di.MapComponentHolder
import com.example.general.location.impl.LocationComponentHolder
import dagger.Module
import dagger.Provides

@Module
class ProvideComponentHolderModule {

    @Provides
    fun provideHomeFeatureApiComponentHolder(): HomeFeatureApi {
        HomeComponentHolder.init()
        return HomeComponentHolder.getApi()
    }

    @Provides
    fun provideFavoriteFeatureApiComponentHolder(): FavoriteFeatureApi {
        FavoriteComponentHolder.init()
        return FavoriteComponentHolder.getApi()
    }

    @Provides
    fun provideMapFeatureApiComponentHolder(): MapFeatureApi {
        MapComponentHolder.init()
        return MapComponentHolder.getApi()
    }

    @Provides
    fun provideLocationFeatureApiComponentHolder(): LocationFeatureApi {
        LocationComponentHolder.init()
        return LocationComponentHolder.getApi()
    }
}