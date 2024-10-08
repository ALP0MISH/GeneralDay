package com.example.general.day.home.impl.ui.di

import com.example.general.day.home.api.HomeFeatureApi
import javax.inject.Provider

object HomeComponentHolder {

    @Volatile
    private var component: HomeComponent? = null

    @Volatile
    private var dependencyProvider: Provider<HomeFeatureDependencies>? = null

    fun setDependencyProvider(provider: Provider<HomeFeatureDependencies>) {
        dependencyProvider = provider
    }

    fun getApi(): HomeFeatureApi = checkNotNull(component)

    fun init() {
        synchronized(this) {
            if (component == null) {
                component = HomeComponent.initAndGet(checkNotNull(dependencyProvider).get())
            }
        }
    }
}