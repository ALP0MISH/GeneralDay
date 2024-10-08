package com.example.general.day.detail.impl.di

import com.example.general.day.detail.api.DetailFeatureApi
import javax.inject.Provider

object DetailComponentHolder {

    @Volatile
    private var component: DetailComponent? = null

    @Volatile
    private var dependencyProvider: Provider<DetailFeatureDependencies>? = null

    fun setDependencyProvider(provider: Provider<DetailFeatureDependencies>) {
        dependencyProvider = provider
    }

    fun getApi(): DetailFeatureApi = checkNotNull(component)

    fun init() {
        synchronized(this) {
            if (component == null) {
                component =
                    DetailComponent.initAndGet(checkNotNull(dependencyProvider).get())
            }
        }
    }
}