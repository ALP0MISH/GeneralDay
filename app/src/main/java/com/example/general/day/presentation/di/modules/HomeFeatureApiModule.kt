package com.example.general.day.presentation.di.modules

import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.HomeComponentHolder
import dagger.Provides
import javax.inject.Singleton

object HomeFeatureApiModule {

    @Provides
    @Singleton
    fun provideHomeFeatureApi(): HomeFeatureApi {
        HomeComponentHolder.init()
        return HomeComponentHolder.getApi()
    }
}
