package com.example.general.day.core.managers

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
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
        val isPermissionFineLocationGranted = ContextCompat.checkSelfPermission(
            application.applicationContext,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val isPermissionCoarseLocationGranted = ContextCompat.checkSelfPermission(
            application.applicationContext,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!isPermissionFineLocationGranted || !isPermissionCoarseLocationGranted) {
            showToastManager.showToast(LOCATION_MESSAGE)
            return null
        }

        val currentLocationTask: Task<Location> = locationClient.getCurrentLocation(
            PRIORITY_HIGH_ACCURACY,
            cancellationTokenSource.token,
        )

        return suspendCancellableCoroutine { cancellableContinuation ->
            currentLocationTask.addOnCompleteListener { taskLocation ->
                if (taskLocation.isSuccessful) {
                    val result = taskLocation.result
                    cancellableContinuation.resume(result)
                } else cancellableContinuation.resume(null)
            }
        }
    }
}