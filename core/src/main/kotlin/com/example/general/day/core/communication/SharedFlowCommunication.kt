package com.example.general.day.core.communication

import kotlinx.coroutines.flow.SharedFlow

interface SharedFlowCommunication<T> {

    fun observe(): SharedFlow<T>

    fun emit(source: T)
}