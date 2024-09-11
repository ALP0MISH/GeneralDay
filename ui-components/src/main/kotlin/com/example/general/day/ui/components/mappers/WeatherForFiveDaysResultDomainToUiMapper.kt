package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.helpers.DetermineTimeOfDay
import com.example.general.day.ui.components.helpers.WeatherIconHelper
import com.example.general.day.ui.components.helpers.formatTemperature
import com.example.general.day.ui.components.helpers.toIntegerString
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WindUi
import kotlinx.collections.immutable.persistentListOf
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherForFiveDaysResultDomainToUiMapper @Inject constructor(
    private val windCloudToWindDomain: @JvmSuppressWildcards Mapper<WindDomain, WindUi>,
    private val weatherDomainToUiMapper: @JvmSuppressWildcards Mapper<WeatherDomain, WeatherUi>,
    private val weatherIconHelper: WeatherIconHelper,
    private val determineTimeOfDay: DetermineTimeOfDay
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysResultDomain, @JvmSuppressWildcards WeatherForFiveDaysResultUi> {
    override fun map(from: WeatherForFiveDaysResultDomain): WeatherForFiveDaysResultUi = from.run {
        WeatherForFiveDaysResultUi(
            listTemperature = persistentListOf(weatherTemperature.temperature),
            time = Date(TimeUnit.SECONDS.toMillis(time)),
            rain = rain.hour.toIntegerString(),
            listTime = persistentListOf(),
            wind = windCloudToWindDomain.map(wind),
            tempMin = weatherTemperature.tempMin,
            tempMax = weatherTemperature.tempMax,
            temperature = weatherTemperature.temperature.formatTemperature(),
            main = weather.firstOrNull()?.main ?: "",
            feelsLike = weatherTemperature.feelsLike.formatTemperature(),
            weatherIcon = weatherIconHelper.fetchWeatherIcon(
                weatherHomeUi = weatherDomainToUiMapper.map(
                    weather.firstOrNull() ?: WeatherDomain.unknown
                ), determineTimeOfDay.isDayOrNight(time)
            ),
            weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(time),
            cityName = String(),
            humidity = weatherTemperature.humidity
        )
    }
}