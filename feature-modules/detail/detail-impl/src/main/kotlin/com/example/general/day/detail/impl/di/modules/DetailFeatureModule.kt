package com.example.general.day.detail.impl.di.modules

import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.detail.impl.DetailFeatureImpl
import com.example.general.day.detail.impl.ui.DetailViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

typealias DetailRoute = String

private const val NAMED_DETAIL = "detail"

@Module
class DetailFeatureModule {

    @Provides
    @Named(NAMED_DETAIL)
    fun provideHomeRoute(): DetailRoute = "detailRoute_screen_route"

    @Provides
    fun provideHomeFeatureUiApi(
        @Named(NAMED_DETAIL) route: DetailRoute,
        viewModelFactory: Provider<DetailViewModelFactory>
    ): DetailFeatureUiApi = DetailFeatureImpl(
        route = route,
        viewModelProvider = viewModelFactory
    )
}