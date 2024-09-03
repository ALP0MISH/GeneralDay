package com.example.general.day.home.impl.ui.di

import android.net.ConnectivityManager
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.detail.api.DetailFeatureRouteProvider
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.components.helpers.WeatherDataHelper

interface HomeFeatureDependencies {

    fun getFavoriteRoute(): FavoriteRouteProvider

    fun getMapRoute(): MapRouteProvider

    fun getDetailRoute(): DetailFeatureRouteProvider

    fun getFetchWeatherUseCase(): FetchWeatherUseCase

    fun getLocationTrackerManager(): LocationTrackerManager

    fun getWeatherDataHelper(): WeatherDataHelper

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getCurrentWeatherToHomeUi(): Mapper<CurrentWeatherDomain, CurrentWeatherUi>

    fun getWeatherDomainToHomeUiMapper(): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>

    fun getToastDecorator(): ToastNotificationManger

    fun getSharedPreferences(): SharedPrefManager

    fun getConnectivityManager(): ConnectivityManager
}