package com.example.general.day.presentation.feature.depency

import android.net.ConnectivityManager
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.detail.impl.di.DetailFeatureDependencies
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherByCity
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.presentation.di.DependencyProvider
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import javax.inject.Inject

class DetailFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider,
    private val getToastNotificationManger: ToastNotificationManger,
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val connectivityManager: ConnectivityManager,
    private val weatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
) : DetailFeatureDependencies {

    override fun getFavoriteRoute(): FavoriteRouteProvider {
        return dependencyProvider.favoriteFeatureApi().favoriteRouteProvider
    }

    override fun getMapRoute(): MapRouteProvider {
        return dependencyProvider.mapFeatureApi().mapRouteProvider
    }

    override fun getWeatherByCity(): FetchWeatherByCity {
        return fetchWeatherByCity
    }

    override fun getConnectivityManager(): ConnectivityManager {
        return connectivityManager
    }

    override fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return navigationRouteFlowCommunication
    }

    override fun getToastNotificationManger(): ToastNotificationManger {
        return getToastNotificationManger
    }

    override fun getWeatherDomainToHomeUiMapper(): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi> {
        return weatherDomainToHomeUiMapper
    }
}