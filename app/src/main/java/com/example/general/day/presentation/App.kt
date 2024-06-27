package com.example.general.day.presentation

import android.app.Application
import com.example.general.day.di.AppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerApp
    }

    private fun setUpDagger() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}

