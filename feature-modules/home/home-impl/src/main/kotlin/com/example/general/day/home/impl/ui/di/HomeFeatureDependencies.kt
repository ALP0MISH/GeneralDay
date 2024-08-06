package com.example.general.day.home.impl.ui.di

import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper

interface HomeFeatureDependencies {

    fun getFavoriteRoute(): FavoriteRouteProvider

    fun getMapRoute(): MapRouteProvider

    fun getFetchWeatherUseCase(): FetchWeatherUseCase

    fun getLocationTrackerManager(): LocationTrackerManager

    fun getWeatherDataHelper(): WeatherDataHelper

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getCurrentWeatherToHomeUi(): CurrentWeatherDomainToUiMapper

    fun getWeatherDomainToHomeUiMapper(): WeatherForFiveDaysDomainToUiMapper
}