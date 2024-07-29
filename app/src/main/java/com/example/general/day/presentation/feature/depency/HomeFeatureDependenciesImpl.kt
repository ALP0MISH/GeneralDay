package com.example.general.day.presentation.feature.depency

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.presentation.di.DependencyProvider
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class HomeFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider,
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val locationFeatureApi: LocationFeatureApi,
    private val weatherDataHelper: WeatherDataHelper,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val getCurrentWeatherToHomeUi: CurrentWeatherDomainToUiMapper,
    private val getWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToUiMapper,
) : HomeFeatureDependencies {

    override fun getFavoriteRoute(): FavoriteRouteProvider {
        return dependencyProvider.favoriteFeatureApi().favoriteRouteProvider
    }

    override fun getMapRoute(): MapRouteProvider {
        return dependencyProvider.mapFeatureApi().mapRouteProvider
    }

    override fun getFetchWeatherUseCase(): FetchWeatherUseCase {
        return fetchWeatherUseCase
    }

    override fun getLocationTrackerManager(): LocationTrackerManager {
        return locationFeatureApi.provideLocationTrackerManager()
    }

    override fun getWeatherDataHelper(): WeatherDataHelper {
        return weatherDataHelper
    }

    override fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return navigationRouteFlowCommunication
    }

    override fun getCurrentWeatherToHomeUi(): CurrentWeatherDomainToUiMapper {
        return getCurrentWeatherToHomeUi
    }

    override fun getWeatherDomainToHomeUiMapper(): WeatherForFiveDaysDomainToUiMapper {
        return getWeatherDomainToHomeUiMapper
    }
}