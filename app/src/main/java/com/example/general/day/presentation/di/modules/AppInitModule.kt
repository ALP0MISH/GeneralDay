package com.example.general.day.presentation.di.modules

import com.example.general.day.core.di.OnInitApp
import com.example.general.day.favorite.impl.di.FavoriteComponentHolder
import com.example.general.day.favorite.impl.di.FavoriteFeatureDependencies
import com.example.general.day.home.impl.ui.di.HomeComponentHolder
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.location.impl.LocationComponentHolder
import com.example.general.location.impl.LocationFeatureDependencies
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Provider

@Module
class AppInitModule {

    @Provides
    @IntoSet
    fun initHomeFeatureModule(dependencyProvider: Provider<HomeFeatureDependencies>) = OnInitApp {
        HomeComponentHolder.setDependencyProvider(dependencyProvider)
    }

    @Provides
    @IntoSet
    fun initFavoriteFeatureModule(dependencyProvider: Provider<FavoriteFeatureDependencies>) =
        OnInitApp {
            FavoriteComponentHolder.setDependencyProvider(dependencyProvider)
        }

    @Provides
    @IntoSet
    fun initLocationFeatureModule(dependencyProvider: Provider<LocationFeatureDependencies>) =
        OnInitApp {
            LocationComponentHolder.setDependencyProvider(dependencyProvider)
        }
}