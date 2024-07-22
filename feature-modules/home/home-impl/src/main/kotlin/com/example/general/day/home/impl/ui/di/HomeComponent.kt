package com.example.general.day.home.impl.ui.di

import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HomeScope

@Subcomponent
@HomeScope
interface HomeComponent  {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(homeFeatureImpl: HomeFeatureImpl)
}