package com.example.general.day.detail.impl.di.modules

import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.detail.impl.DetailFeatureImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

typealias DetailRoute = String

@Module
class DetailFeatureModule {

    @Provides
    @Named("detail")
    fun provideHomeRoute(): DetailRoute = "DetailRoute_screen_route"

    @Provides
    fun provideHomeFeatureUiApi(
        @Named("detail") route: DetailRoute,
    ): DetailFeatureUiApi = DetailFeatureImpl(route = route)
}