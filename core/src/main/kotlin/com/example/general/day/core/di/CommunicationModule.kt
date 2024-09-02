package com.example.general.day.core.di

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommunicationModule {

    @Provides
    @Singleton
    fun provideNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return NavigationRouteFlowCommunication.Default()
    }
}