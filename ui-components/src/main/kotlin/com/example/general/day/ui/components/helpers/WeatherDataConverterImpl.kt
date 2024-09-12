package com.example.general.day.ui.components.helpers

import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherForDetail
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.core.utils.ZoneClusterItem
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.model.polygonOptions
import java.util.UUID
import javax.inject.Inject

class WeatherDataConverterImpl @Inject constructor(
    private val weatherIconProvider: WeatherIconProvider,
    private val timeOfDayEvaluator: TimeOfDayEvaluator,
) : WeatherDataConverter {

    override fun toCurrentConvertedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentConvertedWeather {
        return CurrentConvertedWeather(
            feelsLikeTemperature = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
            weatherBackgroundImage = weatherIconProvider.getBackgroundForTimeOfDay(
                currentWeatherResult.time.toLong(),
            ),
            currentWeatherIcon = weatherIconProvider.getWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                timeOfDayEvaluator.isDayTime(currentWeatherResult.time.toLong())
            ),
            currentTemperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
            currentMonthAndDay = currentWeatherResult.time.toLong().getMonthAndDay(),
            cityName = currentWeatherResult.name,
        )
    }

    override fun toLocalWeather(currentWeatherResult: CurrentWeatherUi): CurrentWeatherLocalUi {
        return CurrentWeatherLocalUi(
            id = UUID.randomUUID().toString(),
            code = currentWeatherResult.cod,
            lat = currentWeatherResult.coordinates.lat,
            lon = currentWeatherResult.coordinates.lon,
            feelsLike = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
            temperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
            tempMax = currentWeatherResult.weatherTemperature.tempMax.formatTemperature(),
            tempMin = currentWeatherResult.weatherTemperature.tempMin.formatTemperature(),
            cityName = currentWeatherResult.name,
            weatherIcon = weatherIconProvider.getWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                timeOfDayEvaluator.isDayTime(currentWeatherResult.time.toLong())
            ),
        )
    }

    override fun toZoneClusterItem(
        currentWeatherResult: CurrentWeatherUi,
        weatherForFiveDaysUi: WeatherForFiveDaysResultUi,
        latLng: LatLng
    ): ZoneClusterItem {
        return ZoneClusterItem(
            polygonOptions = polygonOptions {
                add(
                    LatLng(
                        currentWeatherResult.coordinates.lat,
                        currentWeatherResult.coordinates.lon
                    )
                )
            },
            snippet = "${weatherForFiveDaysUi.tempMax.toIntegerString()}° ${weatherForFiveDaysUi.tempMin.toIntegerString()}°",
            id = UUID.randomUUID().toString(),
            title = currentWeatherResult.name,
            icon = weatherIconProvider.getWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                timeOfDayEvaluator.isDayTime(currentWeatherResult.time.toLong())
            ),
        )
    }

    override fun toDetailedWeather(
        currentWeatherResult: CurrentWeatherUi,
        weatherForFiveDaysUi: WeatherForFiveDaysResultUi
    ): WeatherForDetail {
        with(weatherForFiveDaysUi) {
            return WeatherForDetail(
                listTemperature = listTemperature,
                time = time,
                rain = rain,
                listTime = listTime,
                wind = wind,
                tempMin = tempMin,
                tempMax = tempMax,
                temperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
                main = main,
                feelsLike = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
                weatherIcon = weatherIconProvider.getWeatherIcon(
                    weatherHomeUi = currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                    timeOfDayEvaluator.isDayTime(currentWeatherResult.time.toLong())
                ),
                weatherBackgroundImage = weatherIconProvider.getBackgroundForTimeOfDay(
                    currentWeatherResult.time.toLong()
                ),
                cityName = cityName,
                humidity = humidity
            )
        }
    }
}