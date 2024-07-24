package com.example.general.day.presentation.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.map.impl.MapFeatureImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeFeatureModule {

    @Provides
    @Singleton
    fun provideHomeFeatureApi(): HomeFeatureApi {
        return HomeFeatureImpl()
    }

    @Provides
    @Singleton
    fun provideSettingsFeatureApi(): FavoriteFeatureApi {
        return FavoriteFeatureImpl()
    }

//    @Provides
//    @Singleton
//    fun provideOnboardingFeatureApi(): MapFeatureApi {
//        return MapFeatureImpl()
//    }
}
