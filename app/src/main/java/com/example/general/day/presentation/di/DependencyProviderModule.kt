package com.example.general.day.presentation.di

import com.example.general.day.presentation.feature.depency.DependencyProviderImpl
import dagger.Binds
import dagger.Module

@Module
interface DependencyProviderModule {

    @Binds
    fun provideDependencyProvider(
        implementation: DependencyProviderImpl
    ): DependencyProvider
}