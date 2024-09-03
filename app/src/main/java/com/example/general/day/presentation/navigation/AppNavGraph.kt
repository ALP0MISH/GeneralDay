package com.example.general.day.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.general.day.core.FeatureApi
import com.example.general.day.core.observeWithLifecycle
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.presentation.ApplicationViewModel
import com.example.general.day.presentation.ApplicationViewModelFactory
import com.example.general.day.presentation.di.DependencyProvider
import javax.inject.Provider

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    featureApi: List<FeatureApi>,
    dependencyProvider: DependencyProvider,
    viewModelFactory: Provider<ApplicationViewModelFactory>,
    theme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    Inject(viewModelFactory = viewModelFactory.get()) {
        val viewModel: ApplicationViewModel = daggerViewModel()
        viewModel.navigationRouteFlow.observeWithLifecycle { (route, action) ->
            navController.navigate(route = route, builder = action)
        }
    }
    NavHost(
        navController = navController,
        startDestination = dependencyProvider.homeFeatureApi().homeRouteProvider.getRoute()
    ) {
        featureApi.forEach { api ->
            api.registerGraph(
                navController = navController,
                modifier = modifier,
                navGraphBuilder = this,
                theme = theme,
                onThemeChange = onThemeChange
            )
        }
    }
}