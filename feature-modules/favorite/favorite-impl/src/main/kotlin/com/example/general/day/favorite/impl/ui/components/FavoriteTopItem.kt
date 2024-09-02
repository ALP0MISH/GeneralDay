package com.example.general.day.favorite.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.favorite.impl.ui.FavoriteEvent
import com.example.general.day.ui.core.R.drawable
import com.example.general.day.ui.core.theme.IconTintColorLight
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp8
import com.example.general.day.ui.core.theme.dp9

@Composable
internal fun FavoriteTopItem(
    cityName: String,
    modifier: Modifier = Modifier,
    theme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dp8),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(dp32)
                .clip(RoundedCornerShape(dp8))
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.Gray
            )
        }
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.ExtraBold
        )
        Box(
            modifier = Modifier
                .size(dp32)
                .clip(RoundedCornerShape(dp8))
                .background(MaterialTheme.colorScheme.secondary)
                .clickable { onThemeChange(!theme) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(drawable.loader),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun FavoriteTopItemPreview() {
    MaterialTheme {
        FavoriteTopItem(
            cityName = String(),
            theme = false,
            onThemeChange = {}
        )
    }
}