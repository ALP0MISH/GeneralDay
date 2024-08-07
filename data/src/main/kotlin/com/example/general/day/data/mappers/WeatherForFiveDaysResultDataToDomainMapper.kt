package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CloudsData
import com.example.general.day.data.models.ForRainOrSnowData
import com.example.general.day.data.models.WeatherData
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.data.models.WeatherSystemInformationData
import com.example.general.day.data.models.WeatherTemperatureData
import com.example.general.day.data.models.WindData
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.domain.models.WindDomain
import javax.inject.Inject

class WeatherForFiveDaysResultDataToDomainMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: @JvmSuppressWildcards Mapper<CloudsData, CloudsDomain>,
    private val weatherTemperatureCloudToDomain: @JvmSuppressWildcards Mapper<WeatherTemperatureData, WeatherTemperatureDomain>,
    private val weatherSystemInformationCloudToDomain: @JvmSuppressWildcards Mapper<WeatherSystemInformationData, WeatherSystemInformationDomain>,
    private val weatherDataToDomainMapper: @JvmSuppressWildcards Mapper<WeatherData, WeatherDomain>,
    private val windCloudToWindDomain: @JvmSuppressWildcards Mapper<WindData, WindDomain>,
    private val forRainOrSnowCloudToDomain: @JvmSuppressWildcards Mapper<ForRainOrSnowData, ForRainOrSnowDomain>,
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysResultData, @JvmSuppressWildcards WeatherForFiveDaysResultDomain> {
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