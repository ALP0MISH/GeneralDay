package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import javax.inject.Inject

class WeatherForFiveDaysResultCloudToDataMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsCloudToDataMapper,
    private val weatherTemperatureCloudToDomain: WeatherTemperatureCloudToDataMapper,
    private val weatherSystemInformationCloudToDomain: WeatherSystemInformationCloudToDataMapper,
    private val weatherCloudToDomain: WeatherCloudToDataMapper,
    private val windCloudToDomain: WindCloudToDataMapper,
    private val forRainOrSnowCloudToDomain: ForRainOrSnowCloudToDataMapper,
) : Mapper<WeatherForFiveDaysResultCloud, WeatherForFiveDaysResultData> {
    override fun map(from: WeatherForFiveDaysResultCloud): WeatherForFiveDaysResultData =
        from.run {
            WeatherForFiveDaysResultData(
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
                weather = weather.map(weatherCloudToDomain::map),
                wind = windCloudToDomain.map(wind),
            )
        }
}