package com.example.general.day.detail.impl.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.components.helpers.toFormattedDate
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp120
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp24
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp6
import com.example.general.day.ui.core.theme.sp48

@Composable
fun DetailScreenContentItem(
    modifier: Modifier = Modifier,
    convertedWeather: WeatherForFiveDaysResultUi,
) {
    Box(
        modifier = modifier
            .fillMaxHeight(0.1f)
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
                text = "Сегодня, ${convertedWeather.time.toFormattedDate()}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
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
            Text(
                modifier = Modifier,
                text = "Ясно, ощущается как ${convertedWeather.feelsLike}",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
            )
            SpacerHeight(size = dp32)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = string.wind),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = stringResource(id = string.humidity),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = stringResource(id = string.precipitation),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${convertedWeather.wind.speed.toInt()}м/с",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${convertedWeather.wind.degrees}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${convertedWeather.rain}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}