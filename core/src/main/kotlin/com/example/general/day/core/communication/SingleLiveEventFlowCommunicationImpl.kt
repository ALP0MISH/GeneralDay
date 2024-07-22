package com.example.general.day.core.communication

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class SingleLiveEventFlowCommunicationImpl<T> : SharedFlowCommunication<T> {

    private val mutableStateFlow = createMutableSharedFlowAsSingleLiveEvent<T>()

    override fun observe(): SharedFlow<T> = mutableStateFlow.asSharedFlow()

    override fun emit(source: T) {
        mutableStateFlow.tryEmit(source)
    }
}