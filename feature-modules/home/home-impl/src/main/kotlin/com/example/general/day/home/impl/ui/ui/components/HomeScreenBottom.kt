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
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.home.impl.ui.HomeScreenEvent
import com.example.general.day.ui.components.models.ConvertedWeatherForFiveDaysUI
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.EachThreeTimeColorDark
import com.example.general.day.ui.core.theme.EachThreeTimeColorLight
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
    convertedWeather: ConvertedWeatherForFiveDaysUI,
    weatherForFiveDays: ImmutableList<ConvertedWeatherForFiveDaysUI>,
    cityName: String,
    dayMonthAndWeek: String,
    onEvent: (HomeScreenEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxHeight(0.14f)
            .fillMaxWidth()
            .padding(bottom = dp8)
            .clip(RoundedCornerShape(dp16))
            .background(if (isSystemInDarkTheme()) IconTintColorDark else IconTintColorLight)
            .clickable { onEvent(HomeScreenEvent.DoNavigateToDetailScreen(cityName)) },
    ) {
        Column(
            modifier = Modifier
                .padding(top = dp16)
                .padding(horizontal = dp20)
        ) {
            Row(
                modifier = Modifier,
            ) {
                Text(
                    modifier = Modifier,
                    text = dayMonthAndWeek,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = convertedWeather.temperatureMax,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                SpacerWidth(dp8)
                Text(
                    text = convertedWeather.temperatureMin,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray,
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
                color = Color.Gray
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
            ) { item ->
                item.eachThreeTime.map { time ->
                    BottomItem(
                        time = "время",
                        temperature = item.temperature,
                        image = item.weatherIcon
                    )
                }
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
            .width(dp73)
            .padding(start = dp8)
            .clip(RoundedCornerShape(dp16))
            .background(if (isSystemInDarkTheme()) EachThreeTimeColorDark else EachThreeTimeColorLight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
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
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun HomeScreenBottomPreview() {
    MaterialTheme {
        HomeScreenBottom(
            onEvent = {},
            convertedWeather = ConvertedWeatherForFiveDaysUI.preview,
            weatherForFiveDays = persistentListOf(),
            cityName = String(),
            dayMonthAndWeek = String()
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