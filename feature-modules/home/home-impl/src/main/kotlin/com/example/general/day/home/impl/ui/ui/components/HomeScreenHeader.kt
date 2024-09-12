package com.example.general.day.home.impl.ui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.home.impl.ui.HomeScreenEvent
import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.dp17
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp4
import com.example.general.day.ui.core.theme.dp8

@Composable
internal fun HomeScreenHeader(
    modifier: Modifier = Modifier,
    cityName: String,
    onEvent: (HomeScreenEvent) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dp17)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(dp32)
                    .clip(RoundedCornerShape(dp8))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onEvent(HomeScreenEvent.DoNavigateToMapScreen) }
                    .padding(dp4),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(drawable.location),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(dp32)
                    .clip(RoundedCornerShape(dp8))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onThemeChange(!isDarkTheme) }
                    .padding(dp4),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(drawable.loader),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            SpacerWidth(size = dp8)
            Box(
                modifier = Modifier
                    .size(dp32)
                    .clip(RoundedCornerShape(dp8))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onEvent(HomeScreenEvent.DoNavigateToFavoriteScreen) }
                    .padding(dp4),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(drawable.search),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = dp17)
        )
    }
}

@Preview
@Composable
fun HomeScreenTopItemPreview() {
    MaterialTheme {
        HomeScreenHeader(
            cityName = "Тамбов",
            onEvent = {},
            onThemeChange = {},
            isDarkTheme = false
        )
    }
}