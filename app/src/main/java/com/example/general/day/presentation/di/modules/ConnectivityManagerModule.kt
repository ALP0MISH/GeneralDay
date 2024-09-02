package com.example.general.day.presentation.di.modules

import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides

@Module
class ConnectivityManagerModule {

    @Provides
    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}