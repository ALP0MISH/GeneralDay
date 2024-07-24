package com.example.general.day.presentation.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.di.HomeComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeFeatureModule {

    @Provides
    @Singleton
    fun provideHomeFeatureApi(homeComponentFactory: HomeComponent.Factory): HomeFeatureApi {
        return HomeFeatureImpl(homeComponentFactory)
    }

    @Provides
    @Singleton
    fun provideSettingsFeatureApi(): FavoriteFeatureApi {
        return FavoriteFeatureImpl()
    }
}
