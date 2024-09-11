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

class WeatherDataHelperImpl @Inject constructor(
    private val weatherIconHelper: WeatherIconHelper,
    private val determineTimeOfDay: DetermineTimeOfDay,
) : WeatherDataHelper {

    override fun currentConvertedWeather(
        currentWeatherResult: CurrentWeatherUi,
    ): CurrentConvertedWeather {
        return CurrentConvertedWeather(
            feelsLikeTemperature = currentWeatherResult.weatherTemperature.feelsLike.formatTemperature(),
            weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(
                currentWeatherResult.time.toLong(),
            ),
            currentWeatherIcon = weatherIconHelper.fetchWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
            ),
            currentTemperature = currentWeatherResult.weatherTemperature.temperature.formatTemperature(),
            currentMonthAndDay = currentWeatherResult.time.toLong().getMonthAndDay(),
            cityName = currentWeatherResult.name,
        )
    }

    override fun convertSavedWeather(currentWeatherResult: CurrentWeatherUi): CurrentWeatherLocalUi {
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
            weatherIcon = weatherIconHelper.fetchWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
            ),
        )
    }

    override fun convertMapWeatherData(
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
            icon = weatherIconHelper.fetchWeatherIcon(
                currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
            ),
        )
    }

    override fun convertWeatherForFiveDays(
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
                weatherIcon = weatherIconHelper.fetchWeatherIcon(
                    weatherHomeUi = currentWeatherResult.weather.firstOrNull() ?: WeatherUi.unknown,
                    determineTimeOfDay.isDayOrNight(currentWeatherResult.time.toLong())
                ),
                weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(
                    currentWeatherResult.time.toLong()
                ),
                cityName = cityName,
                humidity = humidity
            )
        }
    }
}