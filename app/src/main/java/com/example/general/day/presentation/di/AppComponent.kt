package com.example.general.day.presentation.di

import android.content.Context
import com.example.general.day.core.di.CommunicationModule
import com.example.general.day.core.di.CoroutineDispatchersModule
import com.example.general.day.core.di.OnInitApp
import com.example.general.day.core.di.ContextDecoratorModule
import com.example.general.day.data.di.DataModule
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.detail.api.DetailFeatureApi
import com.example.general.day.detail.impl.di.modules.DetailFeatureModule
import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.di.modules.FavoriteFeatureModule
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.modules.HomeFeatureModule
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.map.impl.di.modules.MapFeatureModule
import com.example.general.day.presentation.ApplicationViewModelFactory
import com.example.general.day.presentation.MainActivity
import com.example.general.day.presentation.di.modules.AppInitModule
import com.example.general.day.presentation.di.modules.ConnectivityManagerModule
import com.example.general.day.presentation.di.modules.FeatureApiModule
import com.example.general.day.presentation.di.modules.FeatureDependencyModule
import com.example.general.day.presentation.di.modules.ProvideComponentHolderModule
import com.example.general.day.ui.components.di.MapperModuleUiComponent
import com.example.general.day.ui.components.di.WeatherHelperModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppInitModule::class,
        AppModule::class,
        CoroutineDispatchersModule::class,
        WeatherHelperModule::class,
        DataModule::class,
        ProvideComponentHolderModule::class,
        ContextDecoratorModule::class,
        DependencyProviderModule::class,
        FeatureDependencyModule::class,
        CommunicationModule::class,
        FeatureApiModule::class,
        HomeFeatureModule::class,
        FavoriteFeatureModule::class,
        MapFeatureModule::class,
        DetailFeatureModule::class,
        MapperModuleUiComponent::class,
        ConnectivityManagerModule::class,
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun dependencyProvider(): DependencyProvider
    fun homeFeatureApi(): HomeFeatureApi
    fun favoriteFeatureApi(): FavoriteFeatureApi
    fun detailFeatureApi(): DetailFeatureApi
    fun mapFeatureApi(): MapFeatureApi
    fun getSharedPrefManager(): SharedPrefManager
    fun getApplicationViewModel(): Provider<ApplicationViewModelFactory>
    fun onAllInitAppSet(): Set<OnInitApp>

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }
}