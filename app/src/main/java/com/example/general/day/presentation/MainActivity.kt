package com.example.general.day.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.general.day.core.FeatureApi
import com.example.general.day.presentation.navigation.AppNavGraph
import com.example.general.day.ui.core.theme.WeatherTestAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        setContent {
            WeatherTestAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val appComponent = (LocalContext.current.applicationContext as App).appComponent
                    val dependencyProvider = appComponent.dependencyProvider()
                    val featureApi: List<FeatureApi> = listOf(appComponent.homeFeatureApi().provideHomeFeatureUiApi(), appComponent.favoriteFeatureApi().provideFavoriteFeatureUiApi())

                    AppNavGraph(
                        navController = navController,
                        dependencyProvider = dependencyProvider,
                        featureApi = featureApi
                    )
                }
            }
        }
    }
}