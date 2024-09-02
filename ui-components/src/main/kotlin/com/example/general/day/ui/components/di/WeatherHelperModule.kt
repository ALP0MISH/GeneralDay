package com.example.general.day.ui.components.di

import com.example.general.day.ui.components.helpers.DetermineTimeOfDay
import com.example.general.day.ui.components.helpers.DetermineTimeOfDayImpl
import com.example.general.day.ui.components.helpers.GetWeatherFromString
import com.example.general.day.ui.components.helpers.GetWeatherFromStringImpl
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import com.example.general.day.ui.components.helpers.WeatherDataHelperImpl
import com.example.general.day.ui.components.helpers.WeatherIconHelper
import com.example.general.day.ui.components.helpers.WeatherIconHelperImpl
import dagger.Binds
import dagger.Module

@Module
interface WeatherHelperModule {

    @Binds
    fun bindsDetermineTimeOfDay(
        implementation: DetermineTimeOfDayImpl
    ): DetermineTimeOfDay

    @Binds
    fun bindsGetWeatherFromString(
        implementation: GetWeatherFromStringImpl
    ): GetWeatherFromString

    @Binds
    fun bindsWeatherDataHelper(
        implementation: WeatherDataHelperImpl
    ): WeatherDataHelper

    @Binds
    fun bindsWeatherIconHelper(
        implementation: WeatherIconHelperImpl
    ): WeatherIconHelper
}