package com.example.general.day.detail.impl.ui.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.detail.impl.ui.DetailEvent
import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp17
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp4
import com.example.general.day.ui.core.theme.dp8

@Composable
internal fun DetailScreenTopItem(
    modifier: Modifier = Modifier,
    cityName: String,
    onEvent: (DetailEvent) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onNavigateToBack: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = dp16)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(dp32)
                    .clip(RoundedCornerShape(dp8))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onNavigateToBack() }
                    .padding(dp4),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.weight(1.4f))
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
                    tint = Color.Gray
                )
            }
            SpacerWidth(size = dp8)
            Box(
                modifier = Modifier
                    .size(dp32)
                    .clip(RoundedCornerShape(dp8))
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable { onEvent(DetailEvent.DoNavigateToFavoriteScreen) }
                    .padding(dp4),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(drawable.search),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(top = dp16)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun HomeScreenTopItemPreview() {
    MaterialTheme {
        DetailScreenTopItem(
            cityName = "Тамбов",
            onEvent = {},
            onThemeChange = {},
            isDarkTheme = false,
            onNavigateToBack = {}
        )
    }
}