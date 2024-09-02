package com.example.general.day.presentation.feature.depency

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
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.presentation.di.DependencyProvider
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import javax.inject.Inject

class HomeFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider,
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val locationFeatureApi: LocationFeatureApi,
    private val weatherDataHelper: WeatherDataHelper,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val currentWeatherToHomeUi: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val weatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
    private val getToastNotificationManger: ToastNotificationManger,
    private val sharedPrefManager: SharedPrefManager,
    private val connectivityManager: ConnectivityManager,
) : HomeFeatureDependencies {

    override fun getFavoriteRoute(): FavoriteRouteProvider {
        return dependencyProvider.favoriteFeatureApi().favoriteRouteProvider
    }

    override fun getMapRoute(): MapRouteProvider {
        return dependencyProvider.mapFeatureApi().mapRouteProvider
    }

    override fun getDetailRoute(): DetailFeatureRouteProvider {
        return dependencyProvider.detailFeatureApi().detailFeatureRouteProvider
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

    override fun getSharedPreferences(): SharedPrefManager {
        return sharedPrefManager
    }

    override fun getConnectivityManager(): ConnectivityManager {
        return connectivityManager
    }
}