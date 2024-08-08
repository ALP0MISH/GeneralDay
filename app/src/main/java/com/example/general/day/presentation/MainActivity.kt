package com.example.general.day.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.general.day.core.FeatureApi
import com.example.general.day.presentation.navigation.AppNavGraph
import com.example.general.day.ui.core.theme.WeatherTestAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        setContent {
            val appComponent = App.instance.appComponent
            var isDarkTheme by rememberSaveable { mutableStateOf(appComponent.getSharedPrefManager().isDarkTheme) }
            WeatherTestAppTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val dependencyProvider = appComponent.dependencyProvider()
                    val featureApi: List<FeatureApi> = listOf(
                        appComponent.homeFeatureApi().provideHomeFeatureUiApi(),
                        appComponent.favoriteFeatureApi().provideFavoriteFeatureUiApi(),
                        appComponent.detailFeatureApi().provideDetailFeatureUiApi()
                    )
                    val viewModelFactory = appComponent.applicationViewModelFactory()
                    AppNavGraph(
                        navController = navController,
                        dependencyProvider = dependencyProvider,
                        featureApi = featureApi,
                        viewModelFactory = viewModelFactory,
                        theme = isDarkTheme,
                        onThemeChange = { newTheme -> isDarkTheme = newTheme }
                    )
                }
            }
        }
    }
}