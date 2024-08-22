package com.example.general.day.data.di

import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.data.local.shared.pref.SharedPrefManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface SharedPrefModule {

    @Binds
    fun bindSharedPref(
        implementation: SharedPrefManagerImpl
    ): SharedPrefManager
}