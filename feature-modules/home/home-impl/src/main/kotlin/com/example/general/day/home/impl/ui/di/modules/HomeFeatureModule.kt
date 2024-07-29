package com.example.general.day.home.impl.ui.di.modules

import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.domain.usecase.FetchWeatherUseCase
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl
import com.example.general.day.home.impl.ui.HomeViewModel
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.location.api.LocationTrackerManager
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToUiMapper
import com.example.general.day.ui.core.weather.helpers.WeatherDataHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named

typealias HomeRoute = String

@Module
class HomeFeatureModule {

    @Provides
    @Named("home")
    fun provideHomeRoute(): HomeRoute = "home_screen_route"

    @Provides
    fun provideHomeFeatureUiApi(
        @Named("home") route: HomeRoute,
        viewModelFactory: DaggerViewModelFactory
    ): HomeFeatureUiApi = HomeFeatureImpl(
        route = route,
        viewModelFactory = viewModelFactory
    )

    @Provides
    fun provideHomeViewModel(
        fetchCurrentWeatherToHomeUi: CurrentWeatherDomainToUiMapper,
        fetchWeatherDomainToHomeUiMapper: WeatherForFiveDaysDomainToUiMapper,
        dependencies: HomeFeatureDependencies,
        getFetchWeatherUseCase: FetchWeatherUseCase,
        getLocationTrackerManager: LocationTrackerManager,
        getWeatherDataHelper: WeatherDataHelper,
        getNavigationRouteFlowCommunication: NavigationRouteFlowCommunication
    ): HomeViewModel {
        return HomeViewModel(
            fetchCurrentWeatherToHomeUi,
            fetchWeatherDomainToHomeUiMapper,
            dependencies,
            getFetchWeatherUseCase,
            getLocationTrackerManager,
            getWeatherDataHelper,
            getNavigationRouteFlowCommunication
        )
    }
}