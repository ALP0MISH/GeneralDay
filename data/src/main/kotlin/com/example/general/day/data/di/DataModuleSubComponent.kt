package com.example.general.day.data.di

import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DataScope

@DataScope
@Subcomponent(
    modules = [DaoModule::class, DataBaseModule::class,
        DataSourceModule::class, MapperModule::class,
        RepositoryModule::class, RetrofitModule::class,
        UseCaseModule::class
    ]
)
interface DataModuleSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DataModuleSubComponent
    }
}