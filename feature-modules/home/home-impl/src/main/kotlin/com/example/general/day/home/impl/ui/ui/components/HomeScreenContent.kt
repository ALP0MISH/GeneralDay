package com.example.general.day.home.impl.ui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.general.day.home.impl.ui.HomeScreenEvent
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.core.extention.SpacerHeight
import com.example.general.day.ui.core.theme.dp100
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp120
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp24
import com.example.general.day.ui.core.theme.dp6
import com.example.general.day.ui.core.theme.sp48

@Composable
internal fun HomeScreenContent(
    modifier: Modifier = Modifier,
    convertedWeather: CurrentConvertedWeather,
    onEvent: (HomeScreenEvent) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.1f)
            .clip(RoundedCornerShape(dp24))
            .clickable { onEvent(HomeScreenEvent.DoNavigateToDetailScreen(convertedWeather.cityName)) },
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
                text = "Сегодня, ${convertedWeather.currentMonthAndDay}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            SpacerHeight(size = dp12)
            Image(
                modifier = Modifier
                    .size(dp120),
                painter = painterResource(id = convertedWeather.currentWeatherIcon),
                contentDescription = null,
            )
            SpacerHeight(size = dp6)
            Text(
                modifier = Modifier,
                text = convertedWeather.currentTemperature,
                fontSize = sp48,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            Text(
                modifier = Modifier,
                text = "Ясно, ощущается как ${convertedWeather.feelsLikeTemperature}",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() {
    MaterialTheme {
        HomeScreenContent(
            convertedWeather = CurrentConvertedWeather.preview,
            onEvent = {}
        )
    }
}
