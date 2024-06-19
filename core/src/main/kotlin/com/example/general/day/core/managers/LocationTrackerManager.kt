package com.example.general.day.core.managers

import android.location.Location

interface LocationTrackerManager {

    suspend fun fetchCurrentLocation(): Location?
}