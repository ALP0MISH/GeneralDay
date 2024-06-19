package com.example.general.day.core.managers

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume

private const val LOCATION_MESSAGE = "Needed Location Permission!"

class LocationTrackerManagerImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application,
    private val showToastManager: ShowToastManager,
) : LocationTrackerManager {

    private val cancellationTokenSource: CancellationTokenSource by lazy {
        CancellationTokenSource()
    }

    @SuppressLint("MissingPermission")
    override suspend fun fetchCurrentLocation(): Location? {
        if (isLocationPermissionNotGranted()) {
            showToastManager.showToast(LOCATION_MESSAGE)
            return null
        }

        val currentLocationTask: Task<Location> = locationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            cancellationTokenSource.token
        )

        return suspendCancellableCoroutine { continuation ->
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