package com.example.general.day.map.impl.di

import com.example.general.day.map.api.MapFeatureApi
import javax.inject.Provider

object MapComponentHolder {

    @Volatile
    private var component: MapComponent? = null

    @Volatile
    private var dependencyProvider: Provider<MapFeatureDependencies>? = null

    fun setDependencyProvider(provider: Provider<MapFeatureDependencies>) {
        dependencyProvider = provider
    }

    internal fun getComponent(): MapComponent = checkNotNull(component)

    @Synchronized
    internal fun initAndGetComponent(): MapComponent {
        init()
        return checkNotNull(component)
    }

    fun getApi(): MapFeatureApi = checkNotNull(component)

    fun init() {
        synchronized(this) {
            if (component == null) {
                component =
                    MapComponent.initAndGet(checkNotNull(dependencyProvider).get())
            }
        }
    }

    fun reset() {
        synchronized(this) {
            component = null
        }
    }
}