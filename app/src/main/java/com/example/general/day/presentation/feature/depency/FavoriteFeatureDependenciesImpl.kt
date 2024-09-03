package com.example.general.day.presentation.feature.depency

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
import com.example.general.day.favorite.impl.di.FavoriteFeatureDependencies
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.presentation.di.DependencyProvider
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.SearchWeatherUi
import com.example.general.day.ui.components.helpers.WeatherDataHelper
import javax.inject.Inject

class FavoriteFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider,
    private val fetchWeatherByCity: FetchWeatherByCity,
    private val weatherDataHelper: WeatherDataHelper,
    private val searchWeatherByCity: SearchWeatherByCity,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val saveCurrentWeatherUseCase: SaveCurrentWeatherUseCase,
    private val toastNotificationManger: ToastNotificationManger,
    private val observeCurrentWeatherUseCase: ObserveCurrentWeatherUseCase,
    private val currentWeatherLocalDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherLocalUi, CurrentWeatherLocalDomain>,
    private val currentWeatherDomainToUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val currentWeatherHomeUiToDomainMapper: @JvmSuppressWildcards Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalUi>,
    private val searchWeatherDomainToUiMapper: @JvmSuppressWildcards Mapper<SearchWeatherDomain, SearchWeatherUi>,
    private val deleteWeatherById: DeleteWeatherById,
    private val sharedPrefManager: SharedPrefManager,
) : FavoriteFeatureDependencies {

    override fun getMapRoute(): MapRouteProvider {
        return dependencyProvider.mapFeatureApi().mapRouteProvider
    }

    override fun getDetailRoute(): DetailFeatureRouteProvider {
        return dependencyProvider.detailFeatureApi().detailFeatureRouteProvider
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

    override fun getShowToastManager(): ToastNotificationManger {
        return toastNotificationManger
    }

    override fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return navigationRouteFlowCommunication
    }

    override fun getCurrentWeatherLocalDomainToHomeUiMapper(): Mapper<CurrentWeatherLocalUi, CurrentWeatherLocalDomain> {
        return currentWeatherLocalDomainToHomeUiMapper
    }

    override fun getCurrentWeatherDomainToUiMapper(): Mapper<CurrentWeatherDomain, CurrentWeatherUi> {
        return currentWeatherDomainToUiMapper
    }

    override fun getSearchWeatherDomainToUiMapper(): Mapper<SearchWeatherDomain, SearchWeatherUi> {
        return searchWeatherDomainToUiMapper
    }

    override fun getCurrentWeatherHomeUiToDomainMapper(): Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalUi> {
        return currentWeatherHomeUiToDomainMapper
    }

    override fun deleteWeatherById(): DeleteWeatherById {
        return deleteWeatherById
    }

    override fun sharedPrefManager(): SharedPrefManager {
        return sharedPrefManager
    }
}