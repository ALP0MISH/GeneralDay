package com.example.general.day.core.di

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import dagger.Module
import dagger.Provides

@Module
class CommunicationModule {

    @Provides
    fun provideNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return NavigationRouteFlowCommunication.Default()
    }
}