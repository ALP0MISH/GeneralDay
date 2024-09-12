package com.example.general.day.detail.impl.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.general.day.ui.components.helpers.toFormattedDate
import com.example.general.day.ui.components.models.WeatherForDetail
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.extention.SpacerWidth
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp120
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp2
import com.example.general.day.ui.core.theme.dp24
import com.example.general.day.ui.core.theme.dp28
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp4
import com.example.general.day.ui.core.theme.dp6
import com.example.general.day.ui.core.theme.dp8
import com.example.general.day.ui.core.theme.sp32
import com.example.general.day.ui.core.theme.sp48

@Composable
fun DetailScreenContentItem(
    modifier: Modifier = Modifier,
    convertedWeather: WeatherForDetail,
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .clip(RoundedCornerShape(dp24))
    ) {
        Image(
            painter = painterResource(id = convertedWeather.weatherBackgroundImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = dp16),
                text = convertedWeather.time.toFormattedDate(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            SpacerHeight(size = dp12)
            Image(
                modifier = Modifier
                    .size(dp120),
                painter = painterResource(id = convertedWeather.weatherIcon),
                contentDescription = null,
            )
            SpacerHeight(size = dp6)
            Text(
                modifier = Modifier,
                text = convertedWeather.temperature,
                fontSize = sp48,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = string.clearly_feels_like),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White,
                )
                SpacerWidth(size = dp4)
                Text(
                    modifier = Modifier,
                    text = convertedWeather.feelsLike,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White,
                )
            }
            SpacerHeight(size = dp32)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp28),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                WeatherInfoItem(
                    label = string.wind,
                    value = "${convertedWeather.wind.speed.toInt()}",
                    unit = string.meter_per_hour
                )
                WeatherInfoItem(
                    label = string.humidity,
                    value = "${convertedWeather.humidity}",
                    unit = string.percent
                )
                WeatherInfoItem(
                    label = string.precipitation,
                    value = convertedWeather.rain,
                    unit = string.percent
                )
            }
        }
    }
}

@Composable
fun WeatherInfoItem(
    label: Int,
    value: String,
    unit: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpacerHeight(size = dp6)
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = sp32,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = unit),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = dp2, top = dp8)
            )
        }
    }
}