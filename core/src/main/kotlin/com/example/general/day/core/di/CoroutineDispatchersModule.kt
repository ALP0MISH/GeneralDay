package com.example.general.day.core.di

import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.core.dispatchers.CoroutineDispatchersImpl
import dagger.Module
import dagger.Provides

@Module
class CoroutineDispatchersModule {

    @Provides
    fun provideCoroutineDispatchers(): CoroutineDispatchers = CoroutineDispatchersImpl()
}