package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import javax.inject.Inject

class WeatherForFiveDaysResultCloudToDataMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsCloudToDataMapper,
    private val weatherTemperatureCloudToWeatherTemperatureDomain: WeatherTemperatureCloudToDataMapper,
    private val weatherSystemInformationCloudToWeatherSystemInformationDomain: WeatherSystemInformationCloudToDataMapper,
    private val weatherCloudToWeatherDomain: WeatherCloudToDataMapper,
    private val windCloudToWindDomain: WindCloudToDataMapper,
    private val forRainOrSnowCloudToForRainOrSnowDomain: ForRainOrSnowCloudToDataMapper,
) : Mapper<WeatherForFiveDaysResultCloud, WeatherForFiveDaysResultData> {
    override fun map(from: WeatherForFiveDaysResultCloud): WeatherForFiveDaysResultData =
        from.run {
            WeatherForFiveDaysResultData(
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
                weather = weather.map(weatherCloudToWeatherDomain::map),
                wind = windCloudToWindDomain.map(wind),
            )
        }
}