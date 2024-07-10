    package com.example.general.day.ui.components.di

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.mappers.CityDomainToCityHomeUiMapper
import com.example.general.day.ui.components.mappers.CloudsDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CoordinatesDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherHomeUiToDomainMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.ForRainOrSnowDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysResultDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherSystemInformationDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WeatherTemperatureDomainToHomeUiMapper
import com.example.general.day.ui.components.mappers.WindDomainToHomeUIMapper
import com.example.general.day.ui.components.models.CityHomeUi
import com.example.general.day.ui.components.models.CloudsHomeUi
import com.example.general.day.ui.components.models.CoordinatesHomeUi
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.CurrentWeatherLocalHomeUi
import com.example.general.day.ui.components.models.ForRainOrSnowHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultHomeUi
import com.example.general.day.ui.components.models.WeatherHomeUi
import com.example.general.day.ui.components.models.WeatherSystemInformationHomeUi
import com.example.general.day.ui.components.models.WeatherTemperatureHomeUi
import com.example.general.day.ui.components.models.WindHomeUi

import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun bindsCityDomainToCityHomeUiMapper(
        implementation: CityDomainToCityHomeUiMapper
    ): Mapper<CityDomain, CityHomeUi>

    @Binds
    fun bindsCloudsDomainToHomeUiMapper(
        implementation: CloudsDomainToHomeUiMapper
    ): Mapper<CloudsDomain, CloudsHomeUi>

    @Binds
    fun bindsCoordinatesDomainToHomeUiMapper(
        implementation: CoordinatesDomainToHomeUiMapper
    ): Mapper<CoordinatesDomain, CoordinatesHomeUi>

    @Binds
    fun bindsCurrentWeatherDomainToHomeUiMapper(
        implementation: CurrentWeatherDomainToHomeUiMapper
    ): Mapper<CurrentWeatherDomain, CurrentWeatherHomeUi>

    @Binds
    fun bindsCurrentWeatherHomeUiToDomainMapper(
        implementation: CurrentWeatherHomeUiToDomainMapper
    ): Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalHomeUi>

    @Binds
    fun bindsCurrentWeatherLocalDomainToHomeUiMapper(
        implementation: CurrentWeatherLocalDomainToHomeUiMapper
    ): Mapper<CurrentWeatherLocalHomeUi, CurrentWeatherLocalDomain>

    @Binds
    fun bindsForRainOrSnowDomainToHomeUiMapper(
        implementation: ForRainOrSnowDomainToHomeUiMapper
    ): Mapper<ForRainOrSnowDomain, ForRainOrSnowHomeUi>

    @Binds
    fun bindsWeatherDomainToHomeUiMapper(
        implementation: WeatherDomainToHomeUiMapper
    ): Mapper<WeatherDomain, WeatherHomeUi>

    @Binds
    fun bindsWeatherForFiveDaysDomainToHomeUiMapper(
        implementation: WeatherForFiveDaysDomainToHomeUiMapper
    ): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysHomeUi>

    @Binds
    fun bindsWeatherForFiveDaysResultDomainToHomeUiMapper(
        implementation: WeatherForFiveDaysResultDomainToHomeUiMapper
    ): Mapper<WeatherForFiveDaysResultDomain, WeatherForFiveDaysResultHomeUi>

    @Binds
    fun bindsWeatherSystemInformationDomainToHomeUiMapper(
        implementation: WeatherSystemInformationDomainToHomeUiMapper
    ): Mapper<WeatherSystemInformationDomain, WeatherSystemInformationHomeUi>

    @Binds
    fun bindsWeatherTemperatureDomainToHomeUiMapper(
        implementation: WeatherTemperatureDomainToHomeUiMapper
    ): Mapper<WeatherTemperatureDomain, WeatherTemperatureHomeUi>

    @Binds
    fun bindsWindDomainToHomeUIMapper(
        implementation: WindDomainToHomeUIMapper
    ): Mapper<WindDomain, WindHomeUi>
}