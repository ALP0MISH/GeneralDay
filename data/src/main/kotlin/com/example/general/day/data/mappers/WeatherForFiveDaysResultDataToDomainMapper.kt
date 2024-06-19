package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import javax.inject.Inject

class WeatherForFiveDaysResultDataToDomainMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsDataToDomainMapper,
    private val weatherTemperatureCloudToDomain: WeatherTemperatureDataToDomainMapper,
    private val weatherSystemInformationCloudToDomain: WeatherSystemInformationDataToDomainMapper,
    private val weatherDataToDomainMapper: WeatherDataToDomainMapper,
    private val windCloudToWindDomain: WindDataToWindDomainMapper,
    private val forRainOrSnowCloudToDomain: ForRainOrSnowDataToDomainMapper,
) : Mapper<WeatherForFiveDaysResultData, WeatherForFiveDaysResultDomain> {
    override fun map(from: WeatherForFiveDaysResultData): WeatherForFiveDaysResultDomain =
        from.run {
            WeatherForFiveDaysResultDomain(
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