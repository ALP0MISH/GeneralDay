package com.example.general.day.presentation.di.modules

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.di.HomeComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeFeatureModule {

    @Provides
    @Singleton
    fun provideHomeFeatureApi(homeComponentFactory: HomeComponent.Factory): HomeFeatureUiApi {
        return HomeFeatureImpl(homeComponentFactory)
    }

    @Provides
    @Singleton
    fun provideSettingsFeatureApi(): FavoriteFeatureApi {
        return FavoriteFeatureImpl()
    }
}
