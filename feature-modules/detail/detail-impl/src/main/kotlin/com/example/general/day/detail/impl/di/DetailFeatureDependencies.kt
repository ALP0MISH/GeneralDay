package com.example.general.day.detail.impl.di

import android.net.ConnectivityManager
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi

interface DetailFeatureDependencies {

    fun getFavoriteRoute(): FavoriteRouteProvider

    fun getMapRoute(): MapRouteProvider

    fun getWeatherByCity(): FetchWeatherByCity

    fun getConnectivityManager(): ConnectivityManager

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getToastNotificationManger(): ToastNotificationManger

    fun getWeatherDomainToHomeUiMapper(): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>

    fun fetchCurrentWeatherToHomeUi(): @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>

    fun weatherDataHelper(): WeatherDataHelper
}