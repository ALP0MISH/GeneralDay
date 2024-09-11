package com.example.general.day.favorite.impl.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.general.day.favorite.impl.ui.components.AddCityDialog
import com.example.general.day.favorite.impl.ui.components.FavoriteContentItem
import com.example.general.day.favorite.impl.ui.components.FavoriteTopItem
import com.example.general.day.favorite.impl.ui.components.SearchComponent
import com.example.general.day.ui.components.models.SavedWeatherUI
import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.components.LoadingScreen
import com.example.general.day.ui.core.components.LottieErrorScreen
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.AddCityColor
import com.example.general.day.ui.core.theme.dp100
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp17
import com.example.general.day.ui.core.theme.dp24
import com.example.general.day.ui.core.theme.dp40
import com.example.general.day.ui.core.theme.dp8

@Composable
internal fun FavoriteScreen(
    uiState: FavoriteUIState,
    onEvent: (FavoriteEvent) -> Unit,
    modifier: Modifier = Modifier,
    theme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onNavigateToBack: () -> Unit,
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
        if (uiState.isLoading) {
            LoadingScreen()
        } else {
            LazyColumn(
                state = scrollState, modifier = Modifier.fillMaxSize()
            ) {
                item {
                    FavoriteTopSection(
                        uiState = uiState,
                        theme = theme,
                        onThemeChange = onThemeChange,
                        onEvent = onEvent,
                        onNavigateToBack = onNavigateToBack
                    )
                }
                items(
                    uiState.savedWeatherUI.savedWeather, key = { it.id }
                ) { weather ->
                    FavoriteContentItem(
                        temperatureMax = weather.tempMax,
                        temperatureMin = weather.tempMin,
                        cityName = weather.cityName,
                        weatherIcon = weather.weatherIcon,
                        onEvent = onEvent,
                        id = weather.id
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dp100)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.background
                            ),
                            startY = 0f,
                            endY = 300f
                        )
                    )
            )
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
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
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
                        painter = painterResource(id = drawable.location),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
            }
        }
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(dp24))
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    AddCityDialog(
                        onDismissRequest = { showDialog = false },
                        onAddClick = { showDialog = false },
                        onEvent = onEvent,
                        value = uiState.query,
                        uiState = uiState,
                    )
                }
            }
        }
    }
}

@Composable
private fun FavoriteTopSection(
    uiState: FavoriteUIState,
    theme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onEvent: (FavoriteEvent) -> Unit,
    onNavigateToBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        FavoriteTopItem(
            theme = theme,
            onThemeChange = onThemeChange,
            onNavigateToBack = onNavigateToBack
        )
        SearchComponent(
            onEvent = onEvent,
            value = uiState.savedWeatherUI.query,
        )
        Spacer(modifier = Modifier.height(dp8))

        AnimatedVisibility(
            visible = uiState.savedWeatherUI.savedWeather.isEmpty(),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LottieErrorScreen(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {
    MaterialTheme {
        FavoriteScreen(
            uiState = FavoriteUIState(
                savedWeatherUI = SavedWeatherUI.unknown,
            ),
            onEvent = {},
            theme = false,
            onThemeChange = {},
            onNavigateToBack = {}
        )
    }
}