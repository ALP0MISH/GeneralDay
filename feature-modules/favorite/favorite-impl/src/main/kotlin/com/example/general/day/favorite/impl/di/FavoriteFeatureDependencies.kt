package com.example.general.day.favorite.impl.di

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SearchWeatherByCity
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherUiToDomainMapper
import com.example.general.day.ui.components.mappers.SearchWeatherDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper

interface FavoriteFeatureDependencies {

    fun getMapRoute(): MapRouteProvider

    fun getFetchWeatherByCity(): FetchWeatherByCity

    fun getSearchWeatherByCity(): SearchWeatherByCity

    fun getSaveCurrentWeatherUseCase(): SaveCurrentWeatherUseCase

    fun getObserveCurrentWeatherUseCase(): ObserveCurrentWeatherUseCase

    fun getWeatherDataHelper(): WeatherDataHelper

    fun getShowToastManager(): ShowToastManager

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getCurrentWeatherLocalDomainToHomeUiMapper(): CurrentWeatherLocalDomainToUiMapper

    fun getCurrentWeatherDomainToUiMapper(): CurrentWeatherDomainToUiMapper

    fun getSearchWeatherDomainToUiMapper(): SearchWeatherDomainToUiMapper

    fun getCurrentWeatherHomeUiToDomainMapper(): CurrentWeatherUiToDomainMapper
}