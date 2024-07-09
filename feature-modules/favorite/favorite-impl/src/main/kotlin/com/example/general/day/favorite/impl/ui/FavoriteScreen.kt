package com.example.general.day.favorite.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.favorite.impl.ui.components.AddCityDialog
import com.example.general.day.favorite.impl.ui.components.FavoriteContentItem
import com.example.general.day.favorite.impl.ui.components.FavoriteTopItem
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp17
import kotlin.math.min

@Composable
internal fun FavoriteScreen(
    currentWeatherDomain: CurrentWeatherDomain,
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
                    cityName = "osh"
                )
            }
            items(currentWeatherDomain.weather) {
                FavoriteContentItem(
                    temperatureMax = currentWeatherDomain.weatherTemperature.tempMax.toString(),
                    temperatureMin = currentWeatherDomain.weatherTemperature.tempMin.toString(),
                    cityName = currentWeatherDomain.name,
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
            TextButton(
                onClick = { showDialog = true },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "добавить город",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            IconButton(
                onClick = { },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Gray
                )
            ) {
                Icon(
                    painter = painterResource(id = com.example.general.day.ui.core.R.drawable.location),
                    contentDescription = null
                )
            }
        }
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            AddCityDialog(
                onDismissRequest = { showDialog = false },
                onAddClick = { cityName ->
                    showDialog = false
                }
            )
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {
    MaterialTheme {
        FavoriteScreen(
            currentWeatherDomain = CurrentWeatherDomain.unknown
        )
    }
}