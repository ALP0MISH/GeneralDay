package com.example.general.day.presentation.di

import com.example.general.day.data.di.DataModuleSubComponent
import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.di.FavoriteComponent
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.HomeComponent
import com.example.general.day.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, AppModule::class, HomeFeatureModule::class])
interface AppComponent {
    fun inject(application: MainActivity)
    fun favoriteComponent(): FavoriteComponent.Factory
    fun homeComponent(): HomeComponent.Factory
    fun provideHomeFeatureApi(): HomeFeatureApi
    fun provideFavoriteFeatureApi(): FavoriteFeatureApi
    fun provideDataModuleSubComponent(): DataModuleSubComponent.Factory
}