package com.example.general.day.presentation.di.modules

import com.example.general.day.presentation.feature.depency.DependencyProviderImpl
import com.example.general.day.presentation.navigation.DependencyProvider
import com.example.general.day.presentation.navigation.StartDestinationProvider
import com.example.general.day.presentation.navigation.StartDestinationProviderImpl
import dagger.Binds
import dagger.Module

@Module
interface ProvidersModule {

    @Binds
    fun provideDependencyProvider(
        implementation: DependencyProviderImpl
    ): DependencyProvider

    @Binds
    fun provideStartDestinationProvider(
        implementation: StartDestinationProviderImpl
    ): StartDestinationProvider
}