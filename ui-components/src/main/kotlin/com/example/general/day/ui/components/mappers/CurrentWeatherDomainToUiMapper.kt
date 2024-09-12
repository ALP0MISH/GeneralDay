package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.models.CloudsUi
import com.example.general.day.ui.components.models.CoordinatesUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import com.example.general.day.ui.components.models.WeatherTemperatureUi
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WindUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject
import javax.inject.Provider

class CurrentWeatherDomainToUiMapper @Inject constructor(
    private val cloudsDomainToCloudsUi: @JvmSuppressWildcards Mapper<CloudsDomain, CloudsUi>,
    private val weatherTemperatureDomainToUi: @JvmSuppressWildcards Mapper<WeatherTemperatureDomain, WeatherTemperatureUi>,
    private val weatherSystemInformationDomainToUi: @JvmSuppressWildcards Mapper<WeatherSystemInformationDomain, WeatherSystemInformationUi>,
    private val weatherDomainToWeatherUI: @JvmSuppressWildcards Mapper<WeatherDomain, WeatherUi>,
    private val windDomainToWindUi: @JvmSuppressWildcards Mapper<WindDomain, WindUi>,
    private val coordinatesDomainToUi: @JvmSuppressWildcards Mapper<CoordinatesDomain, CoordinatesUi>,
) : Mapper<@JvmSuppressWildcards CurrentWeatherDomain, @JvmSuppressWildcards CurrentWeatherUi> {

    override fun map(from: CurrentWeatherDomain): CurrentWeatherUi = from.run {
        CurrentWeatherUi(
            base = base,
            clouds = cloudsDomainToCloudsUi.map(clouds),
            cod = cod,
            coordinates = coordinatesDomainToUi.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureDomainToUi.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationDomainToUi.map(systemInformation),
            weather = weather.map(weatherDomainToWeatherUI::map).toImmutableList(),
            wind = windDomainToWindUi.map(wind)
        )
    }
}