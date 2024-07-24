package com.example.general.day.presentation.di

import android.content.Context
import com.example.general.day.core.di.CommunicationModule
import com.example.general.day.core.di.CoroutineDispatchersModule
import com.example.general.day.core.di.ShowToastManagerModule
import com.example.general.day.data.di.DataModule
import com.example.general.day.favorite.impl.di.FavoriteComponent
import com.example.general.day.favorite.impl.di.FavoriteViewModelModule
import com.example.general.day.home.impl.ui.di.modules.ViewModelMapModule
import com.example.general.day.presentation.MainActivity
import com.example.general.day.presentation.di.modules.FeatureApiModule
import com.example.general.day.presentation.di.modules.FeatureDependencyModule
import com.example.general.day.presentation.di.modules.HomeFeatureApiModule
import com.example.general.day.presentation.di.modules.ViewModelFactoryModule
import com.example.general.day.ui.core.di.WeatherHelperModule
import com.example.general.location.impl.LocationManagerModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelFactoryModule::class,
        AppModule::class,
        LocationManagerModule::class,
        FavoriteViewModelModule::class,
        CoroutineDispatchersModule::class,
        WeatherHelperModule::class,
        DataModule::class,
        ShowToastManagerModule::class,
        DependencyProviderModule::class,
        FeatureDependencyModule::class,
        CommunicationModule::class,
        ViewModelMapModule::class,
        HomeFeatureApiModule::class,
        FeatureApiModule::class,
    ]
)
interface AppComponent {
    fun inject(application: MainActivity)
    fun favoriteComponent(): FavoriteComponent.Factory
    fun dependencyProvider(): DependencyProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }
}