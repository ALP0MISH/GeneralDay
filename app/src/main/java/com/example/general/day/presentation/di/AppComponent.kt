package com.example.general.day.presentation.di

import android.content.Context
import com.example.general.day.core.di.CommunicationModule
import com.example.general.day.core.di.CoroutineDispatchersModule
import com.example.general.day.core.di.ShowToastManagerModule
import com.example.general.day.data.di.DataModule
import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.di.modules.FavoriteFeatureModule
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.modules.HomeFeatureModule
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.map.impl.di.modules.MapFeatureModule
import com.example.general.day.presentation.MainActivity
import com.example.general.day.presentation.di.modules.FeatureApiModule
import com.example.general.day.presentation.di.modules.FeatureDependencyModule
import com.example.general.day.presentation.di.modules.ProvideComponentHolderModule
import com.example.general.day.presentation.di.modules.ViewModelFactoryModule
import com.example.general.day.presentation.di.modules.ViewModelMapModule
import com.example.general.day.ui.components.di.MapperModuleUiComponent
import com.example.general.day.ui.core.di.WeatherHelperModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelFactoryModule::class,
        AppModule::class,
        CoroutineDispatchersModule::class,
        WeatherHelperModule::class,
        DataModule::class,
        ProvideComponentHolderModule::class,
        ShowToastManagerModule::class,
        DependencyProviderModule::class,
        FeatureDependencyModule::class,
        CommunicationModule::class,
        ViewModelMapModule::class,
        FeatureApiModule::class,
        HomeFeatureModule::class,
        FavoriteFeatureModule::class,
        MapFeatureModule::class,
        MapperModuleUiComponent::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun dependencyProvider(): DependencyProvider
    fun homeFeatureApi(): HomeFeatureApi
    fun favoriteFeatureApi(): FavoriteFeatureApi
    fun mapFeatureApi(): MapFeatureApi

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }
}