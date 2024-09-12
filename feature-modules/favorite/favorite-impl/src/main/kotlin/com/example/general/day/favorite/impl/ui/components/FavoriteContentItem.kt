package com.example.general.day.favorite.impl.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.favorite.impl.ui.FavoriteEvent
import com.example.general.day.ui.core.theme.Gray
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp8
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteContentItem(
    id: String,
    cityName: String,
    temperatureMin: String,
    temperatureMax: String,
    weatherIcon: Int,
    onEvent: (FavoriteEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val dismissState = rememberSwipeToDismissBoxState()

    SwipeToDismissBox(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dp16)),
        state = dismissState,
        backgroundContent = {},
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dp8, bottom = dp8)
                    .clip(RoundedCornerShape(dp16))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onEvent(FavoriteEvent.DoNavigateToDetailScreen(cityName)) }
                    .padding(top = dp16, bottom = dp16),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(start = dp20),
                    text = cityName,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = temperatureMax,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.width(dp8))
                Text(
                    text = temperatureMin,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Gray
                )
                Spacer(modifier = Modifier.width(dp20))
                Image(
                    modifier = Modifier
                        .padding(end = dp20)
                        .size(dp32),
                    painter = painterResource(id = weatherIcon),
                    contentDescription = null
                )
            }
        }
    )
    if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart ||
        dismissState.currentValue == SwipeToDismissBoxValue.StartToEnd
    ) {
        scope.launch {
            onEvent(FavoriteEvent.DoDeleteWeatherById(id))
            dismissState.reset()
        }
    }
}


@Preview
@Composable
fun FavoriteContentItemPreview() {
    MaterialTheme {
        FavoriteContentItem(
            cityName = String(),
            temperatureMin = String(),
            temperatureMax = String(),
            weatherIcon = 0,
            onEvent = {},
            id = String()
        )
    }
}