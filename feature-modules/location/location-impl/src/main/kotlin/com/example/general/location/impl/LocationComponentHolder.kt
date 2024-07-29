package com.example.general.location.impl

import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.location.api.LocationTrackerManager
import javax.inject.Provider

object LocationComponentHolder {

    @Volatile
    private var component: LocationComponent? = null

    @Volatile
    private var dependencyProvider: Provider<LocationFeatureDependencies>? = null

    fun setDependencyProvider(provider: Provider<LocationFeatureDependencies>) {
        dependencyProvider = provider
    }

    internal fun getComponent(): LocationComponent = checkNotNull(component)

    @Synchronized
    internal fun initAndGetComponent(): LocationComponent {
        init()
        return checkNotNull(component)
    }

    fun getApi(): LocationFeatureApi = checkNotNull(component)

    fun init() {
        synchronized(this) {
            if (component == null) {
                component =
                    LocationComponent.initAndGet(checkNotNull(dependencyProvider).get())
            }
        }
    }

    fun reset() {
        synchronized(this) {
            component = null
        }
    }
}