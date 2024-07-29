package com.example.general.day.presentation

import android.app.Application
import com.example.general.day.presentation.di.AppComponent
import com.example.general.day.presentation.di.AppModule
import com.example.general.day.presentation.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .appModule(AppModule(this))
            .build()
    }

    companion object {

        lateinit var instance: App private set
    }
}