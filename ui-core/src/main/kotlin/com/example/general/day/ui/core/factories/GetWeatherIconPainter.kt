package com.example.general.day.ui.core.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.general.day.ui.core.R

@Composable
fun getWeatherIconPainterFactory(weather: WeatherSealedComponent, isDayTime: Boolean): Painter {
    return when (weather) {
        WeatherSealedComponent.Snow -> if (isDayTime) painterResource(id = R.drawable.snow_medium_light) else painterResource(id = R.drawable.snow_medium_nigth)
        WeatherSealedComponent.Rain -> if (isDayTime) painterResource(id = R.drawable.rain_big_ligth) else painterResource(id = R.drawable.rain_big_night)
        WeatherSealedComponent.Clear -> if (isDayTime) painterResource(id = R.drawable.claer_sky_light) else painterResource(id = R.drawable.clear_sky_night)
        WeatherSealedComponent.Cloudy -> if (isDayTime) painterResource(id = R.drawable.partly_cloudy_light) else painterResource(id = R.drawable.partly_cloude_night)
        WeatherSealedComponent.LightRain -> if (isDayTime) painterResource(id = R.drawable.rain_small_light) else painterResource(id = R.drawable.rain_small_night)
        WeatherSealedComponent.Mist -> if (isDayTime) painterResource(id = R.drawable.wind) else painterResource(id = R.drawable.wind)
        WeatherSealedComponent.Thunderstorm -> if (isDayTime) painterResource(id = R.drawable.storm_medium_light) else painterResource(id = R.drawable.storm_medium_night)
        WeatherSealedComponent.Unknown -> if (isDayTime) painterResource(id = R.drawable.mainly_clear_light) else painterResource(id = R.drawable.mainly_clear_night)
    }
}