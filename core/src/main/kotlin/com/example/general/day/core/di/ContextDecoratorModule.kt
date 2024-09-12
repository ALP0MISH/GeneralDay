package com.example.general.day.core.di

import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.ToastNotificationMangerImpl
import dagger.Binds
import dagger.Module

@Module
interface ContextDecoratorModule {

    @Binds
    fun bindContextDecorator(
        implementation: ToastNotificationMangerImpl
    ): ToastNotificationManger
}