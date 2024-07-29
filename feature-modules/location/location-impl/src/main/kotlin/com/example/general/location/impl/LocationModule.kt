package com.example.general.location.impl

import android.app.Application
import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.location.api.LocationTrackerManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides

@Module
class LocationModule {

    @Provides
    fun provideFusedLocationProviderClient(
        application: Application
    ): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application.applicationContext)

    @Provides
    fun provideLocationTrackerManager(
        locationClient: FusedLocationProviderClient,
        showToastManager: ShowToastManager,
        coroutineDispatchers: CoroutineDispatchers,
        application: Application
    ): LocationTrackerManager = LocationTrackerManagerImpl(
        locationClient = locationClient,
        showToastManager = showToastManager,
        coroutineDispatchers = coroutineDispatchers,
        application = application
    )
}