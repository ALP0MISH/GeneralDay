package com.example.general.day.home.impl.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
 import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.general.day.ui.core.threme.EachThreeTimeColor
import com.example.general.day.ui.core.threme.dp16
import com.example.general.day.ui.core.threme.dp20
import com.example.general.day.ui.core.threme.dp32

@Composable
fun HomeScreenBottom(
    monthAndDay: String,
    currentWeather: String,
    maxTemperature: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dp20)
    ) {
        Row(
            modifier = Modifier
                .padding(top = dp16)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = monthAndDay,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = currentWeather,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = maxTemperature,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
            )
        }
        VerticalDivider()
        LazyRow() {

        }
    }
}

@Composable
fun HomeScreenBottomItem(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(dp16)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            color = EachThreeTimeColor
        )
        Icon(
            modifier = Modifier.size(dp32),
            imageVector = Icons.Default.Star,
            contentDescription = null,
        )
        Text(
            text = temperature,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}