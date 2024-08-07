package com.example.general.day.home.impl.ui.di.modules

import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

typealias HomeRoute = String

@Module
class HomeFeatureModule {

    @Provides
    @Named("home")
    fun provideHomeRoute(): HomeRoute = "home_screen_route"

    @Provides
    fun provideHomeFeatureUiApi(
        @Named("home") route: HomeRoute,
        viewModelProvider: Provider<HomeViewModelFactory>
    ): HomeFeatureUiApi = HomeFeatureImpl(
        route = route,
        viewModelProvider = viewModelProvider
    )
}