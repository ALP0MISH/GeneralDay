package com.example.general.day.core.communication
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> createMutableSharedFlowAsSingleLiveEvent(): MutableSharedFlow<T> =
    MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)

fun <T> createMutableSharedFlowAsLiveData(): MutableSharedFlow<T> =
    MutableSharedFlow(1, 0, BufferOverflow.DROP_OLDEST)