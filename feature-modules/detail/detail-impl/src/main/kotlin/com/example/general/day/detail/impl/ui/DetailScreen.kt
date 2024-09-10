package com.example.general.day.detail.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.general.day.detail.impl.ui.componets.DetailScreenBottomItem
import com.example.general.day.detail.impl.ui.componets.DetailScreenContentItem
import com.example.general.day.detail.impl.ui.componets.DetailScreenTopItem
import com.example.general.day.ui.core.components.ErrorScreen
import com.example.general.day.ui.core.components.LoadingScreen
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailScreen(
    uiStateFlow: StateFlow<DetailUiState>,
    onEvent: (DetailEvent) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onNavigateToBack: () -> Unit,
) {
    val uiState by uiStateFlow.collectAsStateWithLifecycle()
    when (uiState) {

        is DetailUiState.Error -> ErrorScreen(
            onRetryClick = { onEvent(DetailEvent.DoRetryFetchWeather) },
            errorMessage = (uiState as? DetailUiState.Error)?.message ?: return
        )

        is DetailUiState.Loaded -> DetailScreenItem(
            uiState = uiState as? DetailUiState.Loaded ?: return,
            onEvent = onEvent,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange,
            onNavigateToBack = onNavigateToBack
        )

        DetailUiState.Loading -> LoadingScreen()
    }
}

@Composable
fun DetailScreenItem(
    uiState: DetailUiState.Loaded,
    onEvent: (DetailEvent) -> Unit,
    isDarkTheme: Boolean,
    onNavigateToBack: () -> Unit,
    onThemeChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dp16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DetailScreenTopItem(
            cityName = uiState.weatherForFiveDays.cityName,
            onEvent = onEvent,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange,
            onNavigateToBack = onNavigateToBack
        )
        SpacerHeight(size = dp20)
        DetailScreenContentItem(
            convertedWeather = uiState.weatherForFiveDays
        )
        SpacerHeight(size = dp20)
        DetailScreenBottomItem(
            uiState = uiState
        )
    }
}