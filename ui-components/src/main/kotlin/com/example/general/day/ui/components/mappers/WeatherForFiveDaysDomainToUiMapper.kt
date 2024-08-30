package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.helpers.DetermineTimeOfDay
import com.example.general.day.ui.components.helpers.WeatherIconHelper
import com.example.general.day.ui.components.helpers.formatTemperature
import com.example.general.day.ui.components.helpers.toIntegerString
import com.example.general.day.ui.components.models.CityUi
import com.example.general.day.ui.components.models.CloudsUi
import com.example.general.day.ui.components.models.ForRainOrSnowUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WindUi
import kotlinx.collections.immutable.toImmutableList
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherForFiveDaysDomainToUiMapper @Inject constructor(
    private val cityDataToCityDomain: @JvmSuppressWildcards Mapper<CityDomain, CityUi>,
    private val cloudsCloudToCloudsDomain: @JvmSuppressWildcards Mapper<CloudsDomain, CloudsUi>,
    private val weatherSystemInformationCloudToDomain: @JvmSuppressWildcards Mapper<WeatherSystemInformationDomain, WeatherSystemInformationUi>,
    private val windCloudToWindDomain: @JvmSuppressWildcards Mapper<WindDomain, WindUi>,
    private val forRainOrSnowCloudToDomain: @JvmSuppressWildcards Mapper<ForRainOrSnowDomain, ForRainOrSnowUi>,
    private val weatherDomainToUiMapper: @JvmSuppressWildcards Mapper<WeatherDomain, WeatherUi>,
    private val weatherSystemInformationMapper: @JvmSuppressWildcards Mapper<WeatherSystemInformationDomain, WeatherSystemInformationUi>,
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
                        clouds = cloudsCloudToCloudsDomain.map(clouds),
                        time = Date(TimeUnit.SECONDS.toMillis(time.toLong())),
                        timeText = timeText,
                        probabilityOfPrecipitation = probabilityOfPrecipitation,
                        rain = rain.hour.toIntegerString(),
                        snow = forRainOrSnowCloudToDomain.map(snow),
                        systemInformation = weatherSystemInformationCloudToDomain.map(
                            systemInformation
                        ),
                        visibility = visibility,
                        wind = windCloudToWindDomain.map(wind),
                        tempMin = weatherTemperature.tempMin.formatTemperature(),
                        tempMax = weatherTemperature.tempMax.formatTemperature(),
                        temperature = weatherTemperature.temperature.formatTemperature(),
                        main = weather.firstOrNull()?.main ?: "",
                        feelsLike = weatherTemperature.feelsLike.formatTemperature(),
                        weatherIcon = weatherIconHelper.fetchWeatherIcon(
                            weatherHomeUi = weatherDomainToUiMapper.map(
                                weather.firstOrNull() ?: WeatherDomain.unknown
                            ), determineTimeOfDay.isDayOrNight(time.toLong())
                        ),
                        weatherBackgroundImage = weatherIconHelper.fetchBackgroundForTimeOfDay(
                            time.toLong(),
                            weatherSystemInfo = weatherSystemInformationMapper.map(systemInformation)
                        ),
                        cityName = from.city.name
                    )
                }
            }.toImmutableList()
        )
    }
}