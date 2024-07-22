package com.example.general.day.presentation.di

import com.example.general.day.home.impl.ui.HomeFeatureDependencies
import com.example.general.day.presentation.feature.depency.HomeFeatureDependenciesImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureDependencyModule {

    @Binds
    fun bindsHomeFeatureDependencies(
        implementation: HomeFeatureDependenciesImpl
    ): HomeFeatureDependencies
}