package com.example.general.day.home.impl.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.home.impl.models.WeatherForFiveDaysResultHomeUi
import javax.inject.Inject

class WeatherForFiveDaysResultDomainToHomeUiMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsDomainToHomeUiMapper,
    private val weatherTemperatureCloudToWeatherTemperatureDomain: WeatherTemperatureDomainToHomeUiMapper,
    private val weatherSystemInformationCloudToWeatherSystemInformationDomain: WeatherSystemInformationDomainToHomeUiMapper,
    private val weatherDataToDomainMapper: WeatherDomainToHomeUiMapper,
    private val windCloudToWindDomain: WindDomainToHomeUIMapper,
    private val forRainOrSnowCloudToForRainOrSnowDomain: ForRainOrSnowDomainToHomeUiMapper,
) : Mapper<WeatherForFiveDaysResultDomain, WeatherForFiveDaysResultHomeUi> {
    override fun map(from: WeatherForFiveDaysResultDomain): WeatherForFiveDaysResultHomeUi =
        from.run {
            WeatherForFiveDaysResultHomeUi(
                clouds = cloudsCloudToCloudsDomain.map(clouds),
                time = time,
                timeText = timeText,
                weatherTemperature = weatherTemperatureCloudToWeatherTemperatureDomain.map(
                    weatherTemperature
                ),
                probabilityOfPrecipitation = probabilityOfPrecipitation,
                rain = forRainOrSnowCloudToForRainOrSnowDomain.map(rain),
                snow = forRainOrSnowCloudToForRainOrSnowDomain.map(snow),
                systemInformation = weatherSystemInformationCloudToWeatherSystemInformationDomain.map(
                    systemInformation
                ),
                visibility = visibility,
                weather = weather.map(weatherDataToDomainMapper::map),
                wind = windCloudToWindDomain.map(wind),
            )
        }
}