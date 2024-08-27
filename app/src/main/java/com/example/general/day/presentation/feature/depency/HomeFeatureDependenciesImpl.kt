package com.example.general.day.presentation.feature.depency

import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.presentation.di.DependencyProvider
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import javax.inject.Inject

class HomeFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider,
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val locationFeatureApi: LocationFeatureApi,
    private val weatherDataHelper: WeatherDataHelper,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val currentWeatherToHomeUi: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val weatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
    private val getToastNotificationManger: ToastNotificationManger
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

    override fun getCurrentWeatherToHomeUi(): Mapper<CurrentWeatherDomain, CurrentWeatherUi> {
        return currentWeatherToHomeUi
    }

    override fun getWeatherDomainToHomeUiMapper(): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi> {
        return weatherDomainToHomeUiMapper
    }

    override fun getToastDecorator(): ToastNotificationManger {
        return getToastNotificationManger
    }
}