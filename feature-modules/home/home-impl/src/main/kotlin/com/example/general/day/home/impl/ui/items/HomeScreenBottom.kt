package com.example.general.day.home.impl.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.general.day.home.impl.models.WeatherForFiveDaysHomeUi
import com.example.general.day.home.impl.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.core.extention.getMonthAndDayOfWeek
import com.example.general.day.ui.core.threme.EachThreeTimeColor
import com.example.general.day.ui.core.threme.dp16
import com.example.general.day.ui.core.threme.dp20
import com.example.general.day.ui.core.threme.dp32
import kotlinx.collections.immutable.ImmutableList
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreenBottom(
    weatherList: WeatherForFiveDaysResultHomeUi,
    weatherForFiveDaysHomeUi: WeatherForFiveDaysHomeUi,
    modifier: Modifier = Modifier,
) {
    val monthAndDay = getMonthAndDayOfWeek(weatherList.time.toLong())
    val dailyMinMaxTemperatures = calculateDailyMinMaxTemperatures(weatherForFiveDaysHomeUi.list)
    val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale("ru")).format(Date())
    val (minTemperature, maxTemperature) = dailyMinMaxTemperatures[currentDate] ?: (0.0 to 0.0)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dp20)
    ) {
        Row(
            modifier = Modifier
                .padding(top = dp16)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = monthAndDay,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = "Min: ${"%.1f".format(minTemperature)}°C",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
            )
            Text(
                text = "Max: ${"%.1f".format(maxTemperature)}°C",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
            )
        }
    }
    VerticalDivider()
    LazyRow {
        items(
            items = weatherList.weather,
        ) {
            HomeScreenBottomItem(
                time = weatherList.time.toString(),
                temperature = weatherList.weatherTemperature.temperature.toString()
            )
        }
    }
}


@Composable
fun HomeScreenBottomItem(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(dp16)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            color = EachThreeTimeColor
        )
        Icon(
            modifier = Modifier.size(dp32),
            imageVector = Icons.Default.Star,
            contentDescription = null,
        )
        Text(
            text = temperature,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

fun calculateDailyMinMaxTemperatures(weatherDataList: ImmutableList<WeatherForFiveDaysResultHomeUi>): Map<String, Pair<Double, Double>> {
    return weatherDataList.groupBy { it.timeText.substring(0, 10) }
        .mapValues { entry ->
            val dailyTemperatures = entry.value.map { it.weatherTemperature.temperature - 273.15 }
            dailyTemperatures.minOrNull()!! to dailyTemperatures.maxOrNull()!!
        }
}