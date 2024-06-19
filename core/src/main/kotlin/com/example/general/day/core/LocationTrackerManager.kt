package com.example.general.day.core

import android.location.Location

interface LocationTrackerManager {

    suspend fun fetchCurrentLocation(): Location?
}