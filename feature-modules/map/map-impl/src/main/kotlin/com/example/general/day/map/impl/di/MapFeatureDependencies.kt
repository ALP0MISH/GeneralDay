package com.example.general.day.map.impl.di

import android.content.Context
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.helpers.WeatherDataConverter
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi

interface MapFeatureDependencies {

    fun getContext(): Context

    fun getFetchWeatherUseCase(): FetchWeatherUseCase

    fun getToastNotificationManger(): ToastNotificationManger

    fun getLocationTrackerManager(): LocationTrackerManager

    fun getWeatherDataHelper(): WeatherDataConverter

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getCurrentWeatherDomainToHomeUiMapper(): Mapper<CurrentWeatherDomain, CurrentWeatherUi>

    fun sharedPreferences(): SharedPrefManager

    fun fetchWeatherDomainToHomeUiMapper(): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>
}