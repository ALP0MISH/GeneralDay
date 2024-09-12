package com.example.general.day.home.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.general.day.home.impl.ui.ui.components.HomeScreenFooter
import com.example.general.day.home.impl.ui.ui.components.HomeScreenContent
import com.example.general.day.home.impl.ui.ui.components.HomeScreenHeader
import com.example.general.day.ui.components.helpers.toFormattedDate
import com.example.general.day.ui.components.helpers.toIntegerString
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.core.components.ErrorScreen
import com.example.general.day.ui.core.components.LoadingScreen
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun HomeScreen(
    uiStateFlow: StateFlow<HomeUiState>,
    onEvent: (HomeScreenEvent) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    val uiState by uiStateFlow.collectAsStateWithLifecycle()

    when (uiState) {

        is HomeUiState.Error -> ErrorScreen(
            onRetryClick = { onEvent(HomeScreenEvent.DoRetryFetchWeather) },
            errorMessage = (uiState as? HomeUiState.Error)?.message ?: return
        )

        is HomeUiState.Loaded -> HomeScreenItem(
            uiState = uiState as? HomeUiState.Loaded ?: return,
            onEvent = onEvent,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange
        )

        HomeUiState.Loading -> LoadingScreen()
    }
}

@Composable
internal fun HomeScreenItem(
    modifier: Modifier = Modifier,
    uiState: HomeUiState.Loaded,
    onEvent: (HomeScreenEvent) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = dp16),
    ) {
        item {
            Column(
                modifier = modifier,
            ) {
                HomeScreenHeader(
                    cityName = uiState.currentWeather.cityName,
                    onEvent = onEvent,
                    isDarkTheme = isDarkTheme,
                    onThemeChange = onThemeChange
                )
                Spacer(modifier = Modifier.height(dp20))
                HomeScreenContent(
                    convertedWeather = uiState.currentWeather,
                    onEvent = onEvent
                )
            }
            Spacer(modifier = Modifier.height(dp20))
        }
        items(
            items = uiState.weatherForFiveDays,
            key = { it.weatherId }
        ) { weather ->
            HomeScreenFooter(
                time = weather.time.toFormattedDate(),
                tempMin = "${weather.tempMin.toIntegerString()}°",
                tempMax = "${weather.tempMax.toIntegerString()}°",
                weatherIcon = weather.weatherIcon,
                weatherForFiveDays = weather,
            )
        }
    }
}

@PreviewScreenSizes
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreenItem(
            uiState = HomeUiState.Loaded(
                weatherForFiveDays = persistentListOf(),
                currentWeather = CurrentConvertedWeather.preview,
            ),
            onEvent = {},
            onThemeChange = {},
            isDarkTheme = false
        )
    }
}