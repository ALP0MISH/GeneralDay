package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import javax.inject.Inject

class WeatherForFiveDaysResultCloudToWeatherForFiveDaysDataMapper @Inject constructor(
    private val cloudsCloudToCloudsDomain: CloudsCloudToCloudsDataMapper,
    private val weatherTemperatureCloudToWeatherTemperatureDomain: WeatherTemperatureCloudToWeatherTemperatureDataMapper,
    private val weatherSystemInformationCloudToWeatherSystemInformationDomain: WeatherSystemInformationCloudToWeatherSystemInformationDataMapper,
    private val weatherCloudToWeatherDomain: WeatherCloudToWeatherDataMapper,
    private val windCloudToWindDomain: WindCloudToWindDataMapper,
    private val forRainOrSnowCloudToForRainOrSnowDomain: ForRainOrSnowCloudToForRainOrSnowDataMapper,
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