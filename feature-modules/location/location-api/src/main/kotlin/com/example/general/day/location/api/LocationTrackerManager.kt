package com.example.general.day.location.api

import android.location.Location

interface LocationTrackerManager {

    suspend fun fetchCurrentLocation(): Location?
}