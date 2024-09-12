package com.example.general.day.ui.components.di

import com.example.general.day.ui.components.helpers.TimeOfDayEvaluator
import com.example.general.day.ui.components.helpers.TimeOfDayEvaluatorImpl
import com.example.general.day.ui.components.helpers.GetWeatherFromString
import com.example.general.day.ui.components.helpers.GetWeatherFromStringImpl
import com.example.general.day.ui.components.helpers.WeatherDataConverter
import com.example.general.day.ui.components.helpers.WeatherDataConverterImpl
import com.example.general.day.ui.components.helpers.WeatherIconProvider
import com.example.general.day.ui.components.helpers.WeatherIconProviderImpl
import dagger.Binds
import dagger.Module

@Module
interface WeatherHelperModule {

    @Binds
    fun bindsDetermineTimeOfDay(
        implementation: TimeOfDayEvaluatorImpl
    ): TimeOfDayEvaluator

    @Binds
    fun bindsGetWeatherFromString(
        implementation: GetWeatherFromStringImpl
    ): GetWeatherFromString

    @Binds
    fun bindsWeatherDataHelper(
        implementation: WeatherDataConverterImpl
    ): WeatherDataConverter

    @Binds
    fun bindsWeatherIconHelper(
        implementation: WeatherIconProviderImpl
    ): WeatherIconProvider
}