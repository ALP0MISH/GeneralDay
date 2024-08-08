package com.example.general.day.presentation.feature.depency

import android.app.Application
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.location.impl.LocationFeatureDependencies
import javax.inject.Inject

class LocationFeatureDependenciesImpl @Inject constructor(
    private val toastNotificationManger: ToastNotificationManger,
    private val coroutineDispatchers: CoroutineDispatchers,
    private val application: Application
) : LocationFeatureDependencies {

    override fun getShowToastManager(): ToastNotificationManger {
        return toastNotificationManger
    }

    override fun getCoroutineDispatchers(): CoroutineDispatchers {
        return coroutineDispatchers
    }

    override fun getApplication(): Application {
        return application
    }
}