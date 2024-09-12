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

    fun getApi(): LocationFeatureApi = checkNotNull(component)

    fun init() {
        synchronized(this) {
            if (component == null) {
                component =
                    LocationComponent.initAndGet(checkNotNull(dependencyProvider).get())
            }
        }
    }
}