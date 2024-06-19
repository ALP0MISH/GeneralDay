package com.example.general.day.home.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.general.day.home.impl.ui.items.HomeScreenTopItem
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: StateFlow<HomeUiState>
) {
    Column(
        modifier = modifier,
    ) {
        HomeScreenTopItem(
            cityName = String(),
            onEvent = {}
        )
    }
}

