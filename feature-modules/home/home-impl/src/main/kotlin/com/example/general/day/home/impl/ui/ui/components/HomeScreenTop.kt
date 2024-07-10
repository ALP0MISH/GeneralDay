package com.example.general.day.home.impl.ui.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.home.impl.ui.HomeScreenEvent
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.IconTintColor
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp8

@Composable
internal fun HomeScreenTop(
    modifier: Modifier = Modifier,
    cityName: String,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToMapScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = IconTintColor),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(com.example.general.day.ui.core.R.drawable.light),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.weight(1.4f))
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToFavoriteScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = IconTintColor),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(com.example.general.day.ui.core.R.drawable.light),
                contentDescription = null,
            )
        }
        SpacerWidth(size = dp8)
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToSearchScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = IconTintColor),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(com.example.general.day.ui.core.R.drawable.light),
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
            cityName = "Тамбов",
            onEvent = {}
        )
    }
}