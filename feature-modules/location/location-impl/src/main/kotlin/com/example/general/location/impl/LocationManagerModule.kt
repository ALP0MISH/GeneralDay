package com.example.general.location.impl

import android.app.Application
import com.example.general.day.core.managers.ShowToastManager
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides

@Module
class LocationManagerModule {

    @Provides
    fun provideLocationTrackerManager(
        application: Application,
        showToastManager: ShowToastManager,
    ): com.example.general.day.location.api.LocationTrackerManager =
        LocationTrackerManagerImpl(
            application = application,
            locationClient = LocationServices.getFusedLocationProviderClient(application),
            showToastManager = showToastManager
        )
}