package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import javax.inject.Inject

class WeatherForFiveDaysResultDataToDomainMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsDataToDomainMapper,
    private val weatherTemperatureCloudToWeatherTemperatureDomain: WeatherTemperatureDataToDomainMapper,
    private val weatherSystemInformationCloudToWeatherSystemInformationDomain: WeatherSystemInformationDataToDomainMapper,
    private val weatherDataToDomainMapper: WeatherDataToDomainMapper,
    private val windCloudToWindDomain: WindDataToWindDomainMapper,
    private val forRainOrSnowCloudToForRainOrSnowDomain: ForRainOrSnowDataToDomainMapper,
) : Mapper<WeatherForFiveDaysResultData, WeatherForFiveDaysResultDomain> {
    override fun map(from: WeatherForFiveDaysResultData): WeatherForFiveDaysResultDomain =
        from.run {
            WeatherForFiveDaysResultDomain(
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