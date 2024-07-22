package com.example.general.day.favorite.impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.internal.Provider;
import kotlin.jvm.JvmSuppressWildcards;

@Module
class DaggerViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(
        viewModelsMap:Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory {
        return DaggerViewModelFactory(viewModelsMap)
    }
}