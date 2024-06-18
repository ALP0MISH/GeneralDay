package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import javax.inject.Inject

class WeatherForFiveDaysResultDataToWeatherForFiveDaysDomainMapper @Inject constructor(
    private val cloudsDataToCloudsDomain: CloudsDataToCloudsDomainMapper,
    private val weatherTemperatureDataToWeatherTemperatureDomain: WeatherTemperatureDataToWeatherTemperatureDomainMapper,
    private val weatherSystemInformationDataToWeatherSystemInformationDomain: WeatherSystemInformationDataToWeatherSystemInformationDomainMapper,
    private val weatherDataToWeatherDomain: WeatherDataToWeatherDomainMapper,
    private val windDataToWindDomain: WindDataToWindDomainMapper,
    private val forRainOrSnowDataToForRainOrSnowDomain: ForRainOrSnowDataToForRainOrSnowDomainMapper,
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