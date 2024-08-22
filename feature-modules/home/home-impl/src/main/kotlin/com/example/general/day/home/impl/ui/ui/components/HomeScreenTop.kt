package com.example.general.day.home.impl.ui.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.home.impl.ui.HomeScreenEvent
import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.IconTintColorDark
import com.example.general.day.ui.core.theme.IconTintColorLight
import com.example.general.day.ui.core.theme.dp17
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp8

@Composable
internal fun HomeScreenTop(
    modifier: Modifier = Modifier,
    cityName: String,
    onEvent: (HomeScreenEvent) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dp17),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToMapScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = if (isSystemInDarkTheme()) IconTintColorDark else IconTintColorLight),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(drawable.location),
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
            onClick = { onThemeChange(!isDarkTheme) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = if (isSystemInDarkTheme()) IconTintColorDark else IconTintColorLight),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(drawable.loader),
                contentDescription = null,
            )
        }
        SpacerWidth(size = dp8)
        IconButton(
            onClick = { onEvent(HomeScreenEvent.DoNavigateToFavoriteScreen) },
            colors = IconButtonDefaults.iconButtonColors(containerColor = if (isSystemInDarkTheme()) IconTintColorDark else IconTintColorLight),
            modifier = Modifier.size(dp32),
        ) {
            Icon(
                painter = painterResource(drawable.search),
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
            onEvent = {},
            onThemeChange = {},
            isDarkTheme = false
        )
    }
}