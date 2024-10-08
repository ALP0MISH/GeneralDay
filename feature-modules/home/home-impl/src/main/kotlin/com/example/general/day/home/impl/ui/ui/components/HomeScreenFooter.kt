package com.example.general.day.home.impl.ui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.Gray
import com.example.general.day.ui.core.theme.dp10
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp5
import com.example.general.day.ui.core.theme.dp8

@Composable
fun HomeScreenFooter(
    time: String,
    tempMax: String,
    tempMin: String,
    weatherIcon: Int,
    weatherForFiveDays: WeatherForFiveDaysResultUi,
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
                    text = time,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = tempMax,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.ExtraBold
                )
                SpacerWidth(dp8)
                Text(
                    text = tempMin,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Gray,
                )
                SpacerWidth(dp16)
                Image(
                    modifier = Modifier.size(dp32),
                    painter = painterResource(id = weatherIcon),
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
                items = weatherForFiveDays.weatherForBottomItem,
            ) { item ->
                BottomItem(
                    time = item.time,
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
        HomeScreenFooter(
            time = String(),
            tempMax = String(),
            tempMin = String(),
            weatherIcon = 0,
            weatherForFiveDays = WeatherForFiveDaysResultUi.unknown
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