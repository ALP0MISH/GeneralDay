package com.example.general.location.impl

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.core.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class LocationTrackerManagerImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val toastNotificationManger: ToastNotificationManger,
    private val application: Application
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
            toastNotificationManger.showToast(R.string.location_message)
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