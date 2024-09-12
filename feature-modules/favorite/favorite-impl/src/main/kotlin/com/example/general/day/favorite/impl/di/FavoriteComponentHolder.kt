package com.example.general.day.favorite.impl.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import javax.inject.Provider

object FavoriteComponentHolder {

    @Volatile
    private var component: FavoriteComponent? = null

    @Volatile
    private var dependencyProvider: Provider<FavoriteFeatureDependencies>? = null

    fun setDependencyProvider(provider: Provider<FavoriteFeatureDependencies>) {
        dependencyProvider = provider
    }

    fun getApi(): FavoriteFeatureApi = checkNotNull(component)

    fun init() {
        synchronized(this) {
            if (component == null) {
                component =
                    FavoriteComponent.initAndGet(checkNotNull(dependencyProvider).get())
            }
        }
    }
}