package com.example.general.day.home.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.general.day.home.impl.ui.ui.components.HomeScreenBottom
import com.example.general.day.home.impl.ui.ui.components.HomeScreenContent
import com.example.general.day.home.impl.ui.ui.components.HomeScreenTop
import com.example.general.day.ui.components.models.ConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysHomeUi
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.coroutines.flow.StateFlow

 @Composable
internal fun Home(
    uiStateFlow: StateFlow<HomeUiState>,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    val uiState by uiStateFlow.collectAsStateWithLifecycle()

    when (uiState) {
        is HomeUiState.Error -> Unit
        is HomeUiState.Loaded -> HomeScreen(
            uiState = uiState as HomeUiState.Loaded,
            onEvent = onEvent
        )
        HomeUiState.Loading -> Unit
    }
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState.Loaded,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = dp16),
    ) {
        item {
            Column(
                modifier = modifier,
            ) {
                HomeScreenTop(
                    cityName = uiState.currentWeather.name,
                    onEvent = onEvent
                )
                Spacer(modifier = Modifier.height(dp20))
                HomeScreenContent(
                    convertedWeather = uiState.convertedWeather.firstOrNull() ?: ConvertedWeather.preview,
                    onEvent = onEvent
                )
            }
            Spacer(modifier = Modifier.height(dp20))
            this@LazyColumn.items(
                items = uiState.weatherForFiveDays.list
            ) {
                HomeScreenBottom(
                   convertedWeather = uiState.convertedWeather,
                    onEvent = onEvent
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            uiState = HomeUiState.Loaded(
                weatherForFiveDays = WeatherForFiveDaysHomeUi.unknown,
                currentWeather = CurrentWeatherHomeUi.unknown,
                convertedWeather = persistentListOf()
            ),
            onEvent = {}
        )
    }
}