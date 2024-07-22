package com.example.general.day.core.di

import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.core.managers.ShowToastManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface ShowToastManagerModule {

    @Binds
    fun bindShowToastManager(
        implementation: ShowToastManagerImpl
    ): ShowToastManager
}