package com.example.general.day.presentation.di

import com.example.general.day.favorite.impl.di.FavoriteComponent
import com.example.general.day.home.impl.ui.di.HomeComponent
import com.example.general.day.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, AppModule::class])
interface AppComponent {
    fun inject(application: MainActivity)
    fun mapComponent(): FavoriteComponent.Factory
    fun homeComponent(): HomeComponent.Factory
}