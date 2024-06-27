package com.example.general.day.home.impl.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.`feature-modules`.home.impl.R
import com.example.general.day.home.impl.HomeScreenEvent
import com.example.general.day.ui.core.threme.IconTintColor
import com.example.general.day.ui.core.threme.dp16
import com.example.general.day.ui.core.threme.dp32

@Composable
fun HomeScreenTop(
    modifier: Modifier = Modifier,
    cityName: String,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    Row(
        modifier = modifier.padding(horizontal = dp16),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToMapScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = IconTintColor),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(R.drawable.location),
                contentDescription = null,
            )
        }
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.background
        )
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToFavoriteScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = IconTintColor),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(R.drawable.sun),
                contentDescription = null,
            )
        }
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToSearchScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = IconTintColor),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenTopItemPreview() {
    MaterialTheme {
        HomeScreenTop(
            cityName = String(),
            onEvent = {}
        )
    }
}