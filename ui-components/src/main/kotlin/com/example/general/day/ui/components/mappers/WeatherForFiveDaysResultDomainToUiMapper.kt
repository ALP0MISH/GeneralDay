package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class WeatherForFiveDaysResultDomainToUiMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsDomainToUiMapper,
    private val weatherTemperatureCloudToDomain: WeatherTemperatureDomainToUiMapper,
    private val weatherSystemInformationCloudToDomain: WeatherSystemInformationDomainToUiMapper,
    private val weatherDataToDomainMapper: WeatherDomainToUiMapper,
    private val windCloudToWindDomain: WindDomainToUIMapper,
    private val forRainOrSnowCloudToDomain: ForRainOrSnowDomainToUiMapper,
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysResultDomain, @JvmSuppressWildcards WeatherForFiveDaysResultUi> {
    override fun map(from: WeatherForFiveDaysResultDomain): WeatherForFiveDaysResultUi =
        from.run {
            WeatherForFiveDaysResultUi(
                clouds = cloudsCloudToCloudsDomain.map(clouds),
                time = time,
                timeText = timeText,
                weatherTemperature = weatherTemperatureCloudToDomain.map(
                    weatherTemperature
                ),
                probabilityOfPrecipitation = probabilityOfPrecipitation,
                rain = forRainOrSnowCloudToDomain.map(rain),
                snow = forRainOrSnowCloudToDomain.map(snow),
                systemInformation = weatherSystemInformationCloudToDomain.map(
                    systemInformation
                ),
                visibility = visibility,
                weather = weather.map(weatherDataToDomainMapper::map).toImmutableList(),
                wind = windCloudToWindDomain.map(wind),
            )
        }
}