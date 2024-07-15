package com.example.general.day.home.impl.ui.di

import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.HomeViewModel
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HomeScope

@Subcomponent
@HomeScope
interface HomeComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }
    fun inject(mapViewModel: HomeViewModel)

    fun inject(homeFeatureImpl: HomeFeatureImpl)
}