package com.example.general.location.impl

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.core.extantions.callSafe
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.core.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class LocationTrackerManagerImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val showToastManager: ShowToastManager,
    private val coroutineDispatchers: CoroutineDispatchers,
    private val application: Application
) : LocationTrackerManager {

    private val cancellationTokenSource: CancellationTokenSource by lazy {
        CancellationTokenSource()
    }

    @SuppressLint("MissingPermission")
    override suspend fun fetchCurrentLocation(): Location? =

        callSafe(coroutineDispatchers.io) {
            if (isLocationPermissionNotGranted()) {
                showToastManager.showToast("${R.string.location_message}")
                return@callSafe null
            }
            val currentLocationTask: Task<Location> = locationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                cancellationTokenSource.token
            )

            return@callSafe suspendCancellableCoroutine { continuation ->
                currentLocationTask.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val location: Location = task.result
                        continuation.resume(location)
                    } else {
                        continuation.resume(null)
                    }
                }
            }
        }

    private fun isLocationPermissionNotGranted(): Boolean {
        val fineLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED

        val coarseLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED

        return fineLocationPermission && coarseLocationPermission
    }
}