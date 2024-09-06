package com.example.general.day.home.impl.ui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import com.example.general.day.home.impl.ui.HomeScreenEvent
import com.example.general.day.ui.components.helpers.formatTemperature
import com.example.general.day.ui.components.helpers.toFormattedDate
import com.example.general.day.ui.components.helpers.toFormattedTime
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.EachThreeTimeColorDark
import com.example.general.day.ui.core.theme.EachThreeTimeColorLight
import com.example.general.day.ui.core.theme.Gray
import com.example.general.day.ui.core.theme.IconTintColorDark
import com.example.general.day.ui.core.theme.IconTintColorLight
import com.example.general.day.ui.core.theme.dp10
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp5
import com.example.general.day.ui.core.theme.dp73
import com.example.general.day.ui.core.theme.dp8
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeScreenBottom(
    convertedWeather: WeatherForFiveDaysResultUi,
    weatherForFiveDays: ImmutableList<WeatherForFiveDaysResultUi>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxHeight(0.11f)
            .fillMaxWidth()
            .padding(bottom = dp8)
            .clip(RoundedCornerShape(dp16))
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        Column(
            modifier = Modifier
                .padding(top = dp16)
                .padding(horizontal = dp20)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = convertedWeather.time.toFormattedDate(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = convertedWeather.tempMax.formatTemperature(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.ExtraBold
                )
                SpacerWidth(dp8)
                Text(
                    text = convertedWeather.tempMin.formatTemperature(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Gray,
                )
                SpacerWidth(dp16)
                Image(
                    modifier = Modifier.size(dp32),
                    painter = painterResource(id = convertedWeather.weatherIcon),
                    contentDescription = null,
                )
            }
            SpacerHeight(dp16)
            HorizontalDivider(
                modifier = Modifier,
                color = Gray
            )
        }
        SpacerHeight(dp8)
        LazyRow(
            modifier = Modifier
                .padding(start = dp12)
                .padding(bottom = dp10),
        ) {
            items(
                items = weatherForFiveDays,
                key = { it.weatherId }
            ) { item ->
                BottomItem(
                    time = item.time.toFormattedTime(),
                    temperature = item.temperature,
                    image = item.weatherIcon
                )
            }
        }
    }
}

@Composable
fun BottomItem(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
    image: Int,
) {
    Column(
        modifier = modifier
            .padding(dp8)
            .clip(RoundedCornerShape(dp16))
            .background(MaterialTheme.colorScheme.onSecondary)
            .padding(dp12),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            color = Gray
        )
        SpacerHeight(dp5)
        Image(
            modifier = Modifier.size(dp32),
            painter = painterResource(id = image),
            contentDescription = null,
        )
        SpacerHeight(dp5)
        Text(
            text = temperature,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview
@Composable
fun HomeScreenBottomPreview() {
    MaterialTheme {
        HomeScreenBottom(
            convertedWeather = WeatherForFiveDaysResultUi.preview,
            weatherForFiveDays = persistentListOf(),
        )
    }
}

@Preview
@Composable
fun HomeScreenBottomItemPreview() {
    MaterialTheme {
        BottomItem(
            time = "12:00",
            temperature = "25",
            image = 3,
        )
    }
}