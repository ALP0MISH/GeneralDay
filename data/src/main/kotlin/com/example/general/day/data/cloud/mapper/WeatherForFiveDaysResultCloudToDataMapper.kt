package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CloudsCloud
import com.example.general.day.data.cloud.models.ForRainOrSnowCloud
import com.example.general.day.data.cloud.models.WeatherCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.cloud.models.WeatherSystemInformationCloud
import com.example.general.day.data.cloud.models.WeatherTemperatureCloud
import com.example.general.day.data.cloud.models.WindCloud
import com.example.general.day.data.models.CloudsData
import com.example.general.day.data.models.ForRainOrSnowData
import com.example.general.day.data.models.WeatherData
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.data.models.WeatherSystemInformationData
import com.example.general.day.data.models.WeatherTemperatureData
import com.example.general.day.data.models.WindData
import javax.inject.Inject

class WeatherForFiveDaysResultCloudToDataMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: @JvmSuppressWildcards Mapper<CloudsCloud, CloudsData>,
    private val weatherTemperatureCloudToDomain: @JvmSuppressWildcards Mapper<WeatherTemperatureCloud, WeatherTemperatureData>,
    private val weatherSystemInformationCloudToDomain: @JvmSuppressWildcards Mapper<WeatherSystemInformationCloud, WeatherSystemInformationData>,
    private val weatherCloudToDomain: @JvmSuppressWildcards Mapper<WeatherCloud, WeatherData>,
    private val windCloudToDomain: @JvmSuppressWildcards Mapper<WindCloud, WindData>,
    private val forRainOrSnowCloudToDomain: @JvmSuppressWildcards Mapper<ForRainOrSnowCloud, ForRainOrSnowData>,
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysResultCloud, @JvmSuppressWildcards WeatherForFiveDaysResultData> {
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