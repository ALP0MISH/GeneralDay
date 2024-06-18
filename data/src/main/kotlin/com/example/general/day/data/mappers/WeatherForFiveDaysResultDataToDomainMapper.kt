package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import javax.inject.Inject

class WeatherForFiveDaysResultDataToDomainMapper @Inject constructor(
    private val cloudsDataToCloudsDomain: CloudsDataToDomainMapper,
    private val weatherTemperatureDataToWeatherTemperatureDomain: WeatherTemperatureDataToDomainMapper,
    private val weatherSystemInformationDataToWeatherSystemInformationDomain: WeatherSystemInformationDataToDomainMapper,
    private val weatherDataToWeatherDomain: WeatherDataToDomainMapper,
    private val windDataToWindDomain: WindDataToDomainMapper,
    private val forRainOrSnowDataToForRainOrSnowDomain: ForRainOrSnowDataToDomainMapper,
) : Mapper<WeatherForFiveDaysResultData, WeatherForFiveDaysResultDomain> {
    override fun map(from: WeatherForFiveDaysResultData): WeatherForFiveDaysResultDomain =
        from.run {
            WeatherForFiveDaysResultDomain(
                clouds = cloudsDataToCloudsDomain.map(clouds),
                time = time,
                timeText = timeText,
                weatherTemperature = weatherTemperatureDataToWeatherTemperatureDomain.map(
                    weatherTemperature
                ),
                probabilityOfPrecipitation = probabilityOfPrecipitation,
                rain = forRainOrSnowDataToForRainOrSnowDomain.map(rain),
                snow = forRainOrSnowDataToForRainOrSnowDomain.map(snow),
                systemInformation = weatherSystemInformationDataToWeatherSystemInformationDomain.map(
                    systemInformation
                ),
                visibility = visibility,
                weather = weather.map(weatherDataToWeatherDomain::map),
                wind = windDataToWindDomain.map(wind),
            )
        }
}