package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.helpers.DetermineTimeOfDay
import com.example.general.day.ui.components.helpers.WeatherIconHelper
import com.example.general.day.ui.components.helpers.fetchListWeather
import com.example.general.day.ui.components.helpers.findMaxValue
import com.example.general.day.ui.components.helpers.findMinValue
import com.example.general.day.ui.components.helpers.formatTemperature
import com.example.general.day.ui.components.helpers.getListTime
import com.example.general.day.ui.components.helpers.toIntegerString
import com.example.general.day.ui.components.models.CityUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WindUi
import kotlinx.collections.immutable.toImmutableList
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherForFiveDaysDomainToUiMapper @Inject constructor(
    private val cityDataToCityDomain: @JvmSuppressWildcards Mapper<CityDomain, CityUi>,
    private val windCloudToWindDomain: @JvmSuppressWildcards Mapper<WindDomain, WindUi>,
    private val weatherDomainToUiMapper: @JvmSuppressWildcards Mapper<WeatherDomain, WeatherUi>,
    private val weatherIconHelper: WeatherIconHelper,
    private val determineTimeOfDay: DetermineTimeOfDay
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysDomain, @JvmSuppressWildcards WeatherForFiveDaysUi> {

    override fun map(from: WeatherForFiveDaysDomain): WeatherForFiveDaysUi = from.run {
        WeatherForFiveDaysUi(
            city = cityDataToCityDomain.map(city),
            timeCount = timeCount,
            code = code,
            message = message,
            list = from.groupByDate().map { item ->
                with(item.value.last()) {
                    WeatherForFiveDaysResultUi(
                        listTemperature = item.value.fetchListWeather(),
                        time = Date(TimeUnit.SECONDS.toMillis(time)),
                        rain = rain.hour.toIntegerString(),
                        listTime = item.value.getListTime(),
                        wind = windCloudToWindDomain.map(wind),
                        tempMin = item.value.findMinValue() ?: 0.0,
                        tempMax = item.value.findMaxValue() ?: 30.00,
                        temperature = weatherTemperature.temperature.formatTemperature(),
                        main = weather.firstOrNull()?.main ?: "",
                        feelsLike = weatherTemperature.feelsLike.formatTemperature(),
                        weatherIcon = weatherIconHelper.fetchWeatherIcon(
                            weatherHomeUi = weatherDomainToUiMapper.map(
                                weather.firstOrNull() ?: WeatherDomain.unknown
                            ), determineTimeOfDay.isDayOrNight(time)
                        ),
                        weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(
                            time,
                        ),
                        cityName = from.city.name,
                        humidity = weatherTemperature.humidity
                    )
                }
            }.toImmutableList()
        )
    }
}