package com.example.general.day.data.di

import dagger.Module

@Module(
    includes = [
        DaoModule::class,
        DataBaseModule::class,
        DataSourceModule::class,
        RetrofitModule::class,
        UseCaseModule::class,
        MapperModule::class,
        RepositoryModule::class,
    ],
)
class DataModule