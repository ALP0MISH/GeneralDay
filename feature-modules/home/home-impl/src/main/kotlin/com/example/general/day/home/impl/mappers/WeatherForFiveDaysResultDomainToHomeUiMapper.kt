package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.home.impl.models.WeatherForFiveDaysResultHomeUi
import javax.inject.Inject

class WeatherForFiveDaysResultDomainToHomeUiMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsDomainToHomeUiMapper,
    private val weatherTemperatureCloudToDomain: WeatherTemperatureDomainToHomeUiMapper,
    private val weatherSystemInformationCloudToDomain: WeatherSystemInformationDomainToHomeUiMapper,
    private val weatherDataToDomainMapper: WeatherDomainToHomeUiMapper,
    private val windCloudToWindDomain: WindDomainToHomeUIMapper,
    private val forRainOrSnowCloudToDomain: ForRainOrSnowDomainToHomeUiMapper,
) : Mapper<WeatherForFiveDaysResultDomain, WeatherForFiveDaysResultHomeUi> {
    override fun map(from: WeatherForFiveDaysResultDomain): WeatherForFiveDaysResultHomeUi =
        from.run {
            WeatherForFiveDaysResultHomeUi(
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
                weather = weather.map(weatherDataToDomainMapper::map),
                wind = windCloudToWindDomain.map(wind),
            )
        }
}