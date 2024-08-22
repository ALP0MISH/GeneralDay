package com.example.general.day.ui.core.di

import com.example.general.day.ui.core.weather.helpers.DetermineTimeOfDay
import com.example.general.day.ui.core.weather.helpers.DetermineTimeOfDayImpl
import com.example.general.day.ui.core.weather.helpers.GetWeatherFromString
import com.example.general.day.ui.core.weather.helpers.GetWeatherFromStringImpl
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelperImpl
import com.example.general.day.ui.core.weather.helpers.WeatherIconHelper
import com.example.general.day.ui.core.weather.helpers.WeatherIconHelperImpl
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