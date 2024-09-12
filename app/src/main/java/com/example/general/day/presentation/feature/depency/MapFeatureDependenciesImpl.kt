package com.example.general.day.presentation.feature.depency

import android.app.Application
import android.content.Context
import com.example.general.day.core.Mapper
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.location.api.LocationFeatureApi
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.map.impl.di.MapFeatureDependencies
import com.example.general.day.ui.components.helpers.WeatherDataConverter
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import javax.inject.Inject

class MapFeatureDependenciesImpl @Inject constructor(
    private val application: Application,
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val toastNotificationManger: ToastNotificationManger,
    private val locationTrackerManager: LocationFeatureApi,
    private val weatherDataConverter: WeatherDataConverter,
    private val navigationRouteFlowCommunication: NavigationRouteFlowCommunication,
    private val currentWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<CurrentWeatherDomain, CurrentWeatherUi>,
    private val sharedPreferences: SharedPrefManager,
    private val fetchWeatherDomainToHomeUiMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>,
) : MapFeatureDependencies {

    override fun getContext(): Context = application

    override fun getFetchWeatherUseCase(): FetchWeatherUseCase {
        return fetchWeatherUseCase
    }

    override fun getToastNotificationManger(): ToastNotificationManger {
        return toastNotificationManger
    }

    override fun getLocationTrackerManager(): LocationTrackerManager {
        return locationTrackerManager.provideLocationTrackerManager()
    }

    override fun getWeatherDataHelper(): WeatherDataConverter {
        return weatherDataConverter
    }

    override fun getNavigationRouteFlowCommunication(): NavigationRouteFlowCommunication {
        return navigationRouteFlowCommunication
    }

    override fun getCurrentWeatherDomainToHomeUiMapper(): Mapper<CurrentWeatherDomain, CurrentWeatherUi> {
        return currentWeatherDomainToHomeUiMapper
    }

    override fun sharedPreferences(): SharedPrefManager {
        return sharedPreferences
    }

    override fun fetchWeatherDomainToHomeUiMapper(): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi> {
        return fetchWeatherDomainToHomeUiMapper
    }
}