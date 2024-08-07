package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CloudsData
import com.example.general.day.data.models.CoordinatesData
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.WeatherData
import com.example.general.day.data.models.WeatherSystemInformationData
import com.example.general.day.data.models.WeatherTemperatureData
import com.example.general.day.data.models.WindData
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.domain.models.WindDomain
import javax.inject.Inject

class CurrentWeatherDataToDomainMapper @Inject constructor(
    private val coordinatesDataToDomain: @JvmSuppressWildcards Mapper<CoordinatesData, CoordinatesDomain>,
    private val cloudsDataToCloudsDomain: @JvmSuppressWildcards Mapper<CloudsData, CloudsDomain>,
    private val weatherTemperatureDataToDomain: @JvmSuppressWildcards Mapper<WeatherTemperatureData, WeatherTemperatureDomain>,
    private val weatherSystemInformationDataToDomain: @JvmSuppressWildcards Mapper<WeatherSystemInformationData, WeatherSystemInformationDomain>,
    private val weatherDataToWeatherDomain: @JvmSuppressWildcards Mapper<WeatherData, WeatherDomain>,
    private val windDataToWindDomain: @JvmSuppressWildcards Mapper<WindData, WindDomain>,
) : Mapper<@JvmSuppressWildcards CurrentWeatherData, @JvmSuppressWildcards CurrentWeatherDomain> {

    override fun map(from: CurrentWeatherData): CurrentWeatherDomain = from.run {
        CurrentWeatherDomain(
            base = base,
            clouds = cloudsDataToCloudsDomain.map(clouds),
            cod = cod,
            coordinates = coordinatesDataToDomain.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureDataToDomain.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationDataToDomain.map(
                systemInformation
            ),
            weather = weather.map(weatherDataToWeatherDomain::map),
            wind = windDataToWindDomain.map(wind)
        )
    }
}