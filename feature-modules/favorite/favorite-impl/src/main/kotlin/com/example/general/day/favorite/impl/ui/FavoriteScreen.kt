package com.example.general.day.favorite.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.general.day.favorite.impl.ui.components.AddCityDialog
import com.example.general.day.favorite.impl.ui.components.FavoriteContentItem
import com.example.general.day.favorite.impl.ui.components.FavoriteTopItem
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.AddCityColor
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp17
import com.example.general.day.ui.core.theme.dp40
import com.example.general.day.ui.core.theme.dp8
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun FavoriteScreen(
    uiStateFlow: StateFlow<FavoriteUIState>,
    onEvent: (FavoriteEvent) -> Unit,
) {
    val uiState by uiStateFlow.collectAsStateWithLifecycle()

    when (uiState) {
        is FavoriteUIState.Error -> Unit
        is FavoriteUIState.Loaded -> Favorite(
            uiState = uiState as FavoriteUIState.Loaded,
            onEvent = onEvent
        )
        FavoriteUIState.Loading -> Unit
    }
}

@Composable
internal fun Favorite(
    uiState: FavoriteUIState.Loaded,
    onEvent: (FavoriteEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberLazyListState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = dp17)
            .padding(horizontal = dp16)
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                FavoriteTopItem(
                    cityName = uiState.savedWeather.firstOrNull()?.cityName ?: "osh",
                    onEvent = onEvent
                )
            }
            items(uiState.savedWeather) { weather ->
                FavoriteContentItem(
                    temperatureMax = weather.tempMax,
                    temperatureMin = weather.tempMin,
                    cityName = weather.cityName,
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(dp16)
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                shape = RoundedCornerShape(dp12),
                onClick = { showDialog = true },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = AddCityColor
                )
            ) {
                Text(
                    text = stringResource(id = string.save_city),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }
            SpacerWidth(size = dp8)
            Box(
                modifier = Modifier
                    .size(dp40)
                    .clip(RoundedCornerShape(dp12))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onEvent(FavoriteEvent.DoNavigateToMapScreen) },
                contentAlignment = Alignment.Center
                ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = com.example.general.day.ui.core.R.drawable.location),
                    contentDescription = null,
                    tint = Color.LightGray
                )
            }
        }
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            AddCityDialog(
                onDismissRequest = { showDialog = false },
                onAddClick = {
                    showDialog = false
                },
                onEvent = onEvent,
                cityName = uiState.cityName
            )
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {
    MaterialTheme {
        Favorite(
            uiState = FavoriteUIState.Loaded(
                cityName = "Osh",
                savedWeather = persistentListOf()
            ),
            onEvent = {}
        )
    }
}