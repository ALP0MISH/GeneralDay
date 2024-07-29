package com.example.general.day.map.impl.di

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper

interface MapFeatureDependencies {

    fun getFetchWeatherUseCase(): FetchWeatherUseCase

    fun getLocationTrackerManager(): LocationTrackerManager

    fun getWeatherDataHelper(): WeatherDataHelper

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getCurrentWeatherDomainToHomeUiMapper(): CurrentWeatherDomainToUiMapper
}