package com.example.general.day.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.home.impl.HomeFeatureImpl
import com.example.general.day.home.impl.HomeViewModel
import com.example.general.day.home.impl.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
