package com.example.general.location.impl

import android.app.Application
import android.content.Context
import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.core.managers.ShowToastManager

interface LocationFeatureDependencies {

    fun getShowToastManager(): ShowToastManager

    fun getCoroutineDispatchers(): CoroutineDispatchers

    fun getApplication(): Application
}