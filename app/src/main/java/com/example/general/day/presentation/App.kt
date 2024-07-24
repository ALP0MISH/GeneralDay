package com.example.general.day.presentation

import android.app.Application
import com.example.general.day.favorite.impl.di.FavoriteComponent
import com.example.general.day.home.impl.ui.di.HomeComponent
import com.example.general.day.presentation.di.AppComponent
import com.example.general.day.presentation.di.AppModule
import com.example.general.day.presentation.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    private lateinit var favoriteComponent: FavoriteComponent
    private lateinit var homeComponent: HomeComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .appModule(AppModule(this))
            .build()
        favoriteComponent = appComponent.favoriteComponent().create()
    }

    companion object {

        lateinit var instance: App private set
    }
}