package com.example.general.day.ui.core.communication

import kotlinx.coroutines.flow.SharedFlow

interface SharedFlowCommunication<T> {

    fun observe(): SharedFlow<T>

    fun emit(source: T)
}
