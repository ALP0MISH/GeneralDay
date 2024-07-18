package com.example.general.day.ui.core.di

import com.example.general.day.ui.core.weather.helpers.DetermineTimeOfDay
import com.example.general.day.ui.core.weather.helpers.DetermineTimeOfDayImpl
import com.example.general.day.ui.core.weather.helpers.GetWeatherFromString
import com.example.general.day.ui.core.weather.helpers.GetWeatherFromStringImpl
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelperImpl
import com.example.general.day.ui.core.weather.helpers.WeatherIconHelper
import com.example.general.day.ui.core.weather.helpers.WeatherIconHelperImpl
import dagger.Module
import dagger.Provides

@Module
class WeatherHelperModule {

    @Provides
    fun provideDetermineTimeOfDay(): DetermineTimeOfDay = DetermineTimeOfDayImpl()

    @Provides
    fun provideGetWeatherFromString(): GetWeatherFromString = GetWeatherFromStringImpl()

    @Provides
    fun provideWeatherDataHelper(
        weatherIconHelper: WeatherIconHelper,
        determineTimeOfDay: DetermineTimeOfDay,
    ): WeatherDataHelper = WeatherDataHelperImpl(
        weatherIconHelper,
        determineTimeOfDay
    )

    @Provides
    fun provideWeatherIconHelper(
        getWeatherFromString: GetWeatherFromString,
        determineTimeOfDay: DetermineTimeOfDay,
    ): WeatherIconHelper = WeatherIconHelperImpl(
        getWeatherFromString,
        determineTimeOfDay
    )
}