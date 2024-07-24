package com.example.general.day.presentation.di.modules

import com.example.general.day.core.FeatureApi
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.api.HomeFeatureUiApi
import dagger.Module
import dagger.Provides

@Module
class FeatureApiModule {

    @Provides
    fun provideFeatureApi(
        homeFeatureApi: HomeFeatureApi
    ): List<FeatureApi> = listOf(
        homeFeatureApi.provideHomeFeatureUiApi()
    )
}