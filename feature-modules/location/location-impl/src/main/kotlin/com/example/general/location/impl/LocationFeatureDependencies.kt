package com.example.general.location.impl

import android.app.Application
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.dispatchers.CoroutineDispatchers

interface LocationFeatureDependencies {

    fun getShowToastManager(): ToastNotificationManger

    fun getCoroutineDispatchers(): CoroutineDispatchers

    fun getApplication(): Application
}