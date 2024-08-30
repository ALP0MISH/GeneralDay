package com.example.general.day.detail.impl.di.modules

import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.detail.impl.DetailFeatureImpl
import com.example.general.day.detail.impl.ui.DetailViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

typealias DetailRoute = String

@Module
class DetailFeatureModule {

    @Provides
    @Named("detail")
    fun provideHomeRoute(): DetailRoute = "detailRoute_screen_route"

    @Provides
    fun provideHomeFeatureUiApi(
        @Named("detail") route: DetailRoute,
        viewModelFactory: Provider<DetailViewModelFactory>
    ): DetailFeatureUiApi = DetailFeatureImpl(
        route = route,
        viewModelProvider = viewModelFactory
    )
}