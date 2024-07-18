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
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.core.components.LoadingScreen
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun HomeScreen(
    uiStateFlow: StateFlow<HomeUiState>,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    val uiState by uiStateFlow.collectAsStateWithLifecycle()

    when (uiState) {
        is HomeUiState.Error -> {
            // todo ErrorScreen
        }
        is HomeUiState.Loaded -> HomeScreenItem(
            uiState = uiState as? HomeUiState.Loaded ?: return,
            onEvent = onEvent
        )
        HomeUiState.Loading -> LoadingScreen()
    }
}

@Composable
internal fun HomeScreenItem(
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
                    cityName = uiState.currentWeather.cityName,
                    onEvent = onEvent
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
            items = uiState.weatherForFiveDays
        ) { weather ->
            HomeScreenBottom(
                convertedWeather = weather,
                onEvent = onEvent,
                weatherForFiveDays = uiState.weatherForFiveDays
            )
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreenItem(
            uiState = HomeUiState.Loaded(
                weatherForFiveDays = persistentListOf(),
                currentWeather = CurrentConvertedWeather.preview,
            ),
            onEvent = {}
        )
    }
}