package com.example.general.day.favorite.impl.di

import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.detail.api.DetailFeatureRouteProvider
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.usecase.DeleteWeatherById
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SearchWeatherByCity
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.SearchWeatherUi
import com.example.general.day.ui.components.helpers.WeatherDataHelper

interface FavoriteFeatureDependencies {

    fun getMapRoute(): MapRouteProvider

    fun getDetailRoute(weatherId: String): DetailFeatureRouteProvider

    fun getFetchWeatherByCity(): FetchWeatherByCity

    fun getSearchWeatherByCity(): SearchWeatherByCity

    fun getSaveCurrentWeatherUseCase(): SaveCurrentWeatherUseCase

    fun getObserveCurrentWeatherUseCase(): ObserveCurrentWeatherUseCase

    fun getWeatherDataHelper(): WeatherDataHelper

    fun getShowToastManager(): ToastNotificationManger

    fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication

    fun getCurrentWeatherLocalDomainToHomeUiMapper(): Mapper<CurrentWeatherLocalUi, CurrentWeatherLocalDomain>

    fun getCurrentWeatherDomainToUiMapper(): Mapper<CurrentWeatherDomain, CurrentWeatherUi>

    fun getSearchWeatherDomainToUiMapper(): Mapper<SearchWeatherDomain, SearchWeatherUi>

    fun getCurrentWeatherHomeUiToDomainMapper(): Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalUi>

    fun deleteWeatherById(): DeleteWeatherById

    fun sharedPrefManager(): SharedPrefManager
}