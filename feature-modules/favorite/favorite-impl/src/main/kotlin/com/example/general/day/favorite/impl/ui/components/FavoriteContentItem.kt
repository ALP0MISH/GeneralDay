package com.example.general.day.favorite.impl.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.EachThreeTimeColor
import com.example.general.day.ui.core.theme.IconTintColor
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import com.example.general.day.ui.core.theme.dp30
import com.example.general.day.ui.core.theme.dp8

@Composable
fun FavoriteContentItem(
    cityName: String,
    temperatureMin: String,
    temperatureMax: String,
    weatherIcon: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dp8)
            .clip(RoundedCornerShape(dp16))
            .background(IconTintColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(
                    start = dp20,
                    top = dp16,
                    bottom = dp16
                ),
            text = cityName,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = temperatureMax,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        SpacerWidth(dp8)
        Text(
            text = temperatureMin,
            style = MaterialTheme.typography.bodyLarge,
            color = EachThreeTimeColor
        )
        SpacerWidth(dp16)
        Image(
            modifier = Modifier
                .padding(end = dp16)
                .size(dp30),
            painter = painterResource(id = weatherIcon),
            contentDescription = null
        )
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
            weatherIcon = 0
        )
    }
}