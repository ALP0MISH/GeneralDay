package com.example.general.day.home.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.general.day.home.impl.ui.items.HomeScreenBottom
import com.example.general.day.home.impl.ui.items.HomeScreenContent
import com.example.general.day.home.impl.ui.items.HomeScreenTop
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Home(
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
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState.Loaded,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    LazyColumn {
        item {
            Column(
                modifier = modifier,
            ) {
                HomeScreenTop(
                    cityName = String(),
                    onEvent = onEvent
                )
                HomeScreenContent(
                    weatherList = uiState.currentWeather
                )
            }
            this@LazyColumn.items(
                items = uiState.weatherForFiveDays.list
            ) { item ->
                HomeScreenBottom(
                    weatherList = item,
                    weatherForFiveDaysHomeUi = uiState.weatherForFiveDays
                )
            }
        }
    }
}