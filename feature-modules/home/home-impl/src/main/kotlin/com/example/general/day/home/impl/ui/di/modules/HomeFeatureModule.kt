package com.example.general.day.home.impl.ui.di.modules

import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import dagger.Module
import dagger.Provides

typealias HomeRoute = String

@Module
class HomeFeatureModule {

    @Provides
    fun provideHomeRoute(): HomeRoute = "home_screen"

    @Provides
    fun provideHomeFeatureUiApi(
        route: HomeRoute,
        viewModelFactory: DaggerViewModelFactory
    ): HomeFeatureUiApi = HomeFeatureImpl(
        route = route,
        viewModelFactory = viewModelFactory
    )

}