package com.example.general.day.presentation.feature.depency

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.managers.ShowToastManager
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.domain.usecase.ObserveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SaveCurrentWeatherUseCase
import com.example.general.day.domain.usecase.SearchWeatherByCity
import com.example.general.day.favorite.impl.di.FavoriteFeatureDependencies
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.presentation.di.DependencyProvider
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherUiToDomainMapper
import com.example.general.day.ui.components.mappers.SearchWeatherDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class FavoriteFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider,
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val weatherDataHelper: WeatherDataHelper,
    private val searchWeatherByCity: SearchWeatherByCity,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val showToastManager: ShowToastManager,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: CurrentWeatherLocalDomainToUiMapper,
    private val currentWeatherDomainToUiMapper: CurrentWeatherDomainToUiMapper,
    private val currentWeatherHomeUiToDomainMapper: CurrentWeatherUiToDomainMapper,
    private val searchWeatherDomainToUiMapper: SearchWeatherDomainToUiMapper,
) : FavoriteFeatureDependencies {

    override fun getMapRoute(): MapRouteProvider {
        return dependencyProvider.mapFeatureApi().mapRouteProvider
    }

    override fun getFetchWeatherByCity(): FetchWeatherByCity {
        return fetchWeatherByCity
    }

    override fun getSearchWeatherByCity(): SearchWeatherByCity {
        return searchWeatherByCity
    }

    override fun getSaveCurrentWeatherUseCase(): SaveCurrentWeatherUseCase {
        return saveCurrentWeatherUseCase
    }

    override fun getObserveCurrentWeatherUseCase(): ObserveCurrentWeatherUseCase {
        return observeCurrentWeatherUseCase
    }

    override fun getWeatherDataHelper(): WeatherDataHelper {
        return weatherDataHelper
    }

    override fun getShowToastManager(): ShowToastManager {
        return showToastManager
    }

    override fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return navigationRouteFlowCommunication
    }

    override fun getCurrentWeatherLocalDomainToHomeUiMapper(): CurrentWeatherLocalDomainToUiMapper {
        return currentWeatherLocalDomainToHomeUiMapper
    }

    override fun getCurrentWeatherDomainToUiMapper(): CurrentWeatherDomainToUiMapper {
        return currentWeatherDomainToUiMapper
    }

    override fun getSearchWeatherDomainToUiMapper(): SearchWeatherDomainToUiMapper {
        return searchWeatherDomainToUiMapper
    }

    override fun getCurrentWeatherHomeUiToDomainMapper(): CurrentWeatherUiToDomainMapper {
        return currentWeatherHomeUiToDomainMapper
    }
}