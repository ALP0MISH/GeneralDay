package com.example.general.day.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.general.day.core.observeWithLifecycle
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.presentation.navigation.AppNavGraph
import com.example.general.day.ui.core.theme.WeatherTestAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        setContent {
            val navController = rememberNavController()
            val appComponent = App.instance.appComponent
            val viewModelFactory = appComponent.getApplicationViewModel()
            Inject(viewModelFactory = viewModelFactory.get()) {
                val viewModel: MainActivityViewModel = daggerViewModel()
                viewModel.navigationRouteFlow.observeWithLifecycle { (route, action) ->
                    navController.navigate(route = route, builder = action)
                }

                var isDarkTheme by rememberSaveable { mutableStateOf(viewModel.isDarkTheme()) }

                WeatherTestAppTheme(darkTheme = isDarkTheme) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavGraph(
                            navController = navController,
                            startDestination = viewModel.startDestinationProvider().getRoute(),
                            featureApi = viewModel.getFeatureApiSet(),
                            theme = isDarkTheme,
                            onThemeChange = { newTheme ->
                                isDarkTheme = newTheme
                                viewModel.setDarkTheme(isDarkTheme)
                            }
                        )
                    }
                }
            }
        }
    }
}