package com.example.general.day.ui.components.di

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.domain.models.WindDomain
import com.example.general.day.ui.components.mappers.CityDomainToCityUiMapper
import com.example.general.day.ui.components.mappers.CloudsDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherLocalDomainToUiMapper
import com.example.general.day.ui.components.mappers.CurrentWeatherUiToDomainMapper
import com.example.general.day.ui.components.mappers.ForRainOrSnowDomainToUiMapper
import com.example.general.day.ui.components.mappers.SearchWeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysResultDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherSystemInformationDomainToUiMapper
import com.example.general.day.ui.components.mappers.WeatherTemperatureDomainToUiMapper
import com.example.general.day.ui.components.mappers.WindDomainToUIMapper
import com.example.general.day.ui.components.models.CityUi
import com.example.general.day.ui.components.models.CloudsUi
import com.example.general.day.ui.components.models.CoordinatesUi
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.CurrentWeatherUi
import com.example.general.day.ui.components.models.ForRainOrSnowUi
import com.example.general.day.ui.components.models.SearchWeatherUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysUi
import com.example.general.day.ui.components.models.WeatherSystemInformationUi
import com.example.general.day.ui.components.models.WeatherTemperatureUi
import com.example.general.day.ui.components.models.WeatherUi
import com.example.general.day.ui.components.models.WindUi
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface MapperModuleUiComponent {

    @Binds
    @Singleton
    fun bindCityDomainToCityUiMapper(
        implementation: CityDomainToCityUiMapper
    ): Mapper<CityDomain, CityUi>

    @Binds
    @Singleton
    fun bindCloudsDomainToUiMapper(
        implementation: CloudsDomainToUiMapper
    ): Mapper<CloudsDomain, CloudsUi>

//    @Binds
//    @Singleton
//    fun bindCoordinatesDomainToUiMapper(
//        implementation: CoordinatesDomainToUiMapper
//    ): Mapper<CoordinatesDomain, CoordinatesUi>

    @Binds
    @Singleton
    fun bindCurrentWeatherDomainToUiMapper(
        implementation: CurrentWeatherDomainToUiMapper
    ): Mapper<CurrentWeatherDomain, CurrentWeatherUi>

    @Binds
    @Singleton
    fun bindCurrentWeatherLocalDomainToUiMapper(
        implementation: CurrentWeatherLocalDomainToUiMapper
    ): Mapper<CurrentWeatherLocalUi, CurrentWeatherLocalDomain>

    @Binds
    @Singleton
    fun bindCurrentWeatherUiToDomainMapper(
        implementation: CurrentWeatherUiToDomainMapper
    ): Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalUi>

    @Binds
    @Singleton
    fun bindForRainOrSnowDomainToUiMapper(
        implementation: ForRainOrSnowDomainToUiMapper
    ): Mapper<ForRainOrSnowDomain, ForRainOrSnowUi>

    @Binds
    @Singleton
    fun bindSearchWeatherDomainToUiMapper(
        implementation: SearchWeatherDomainToUiMapper
    ): Mapper<SearchWeatherDomain, SearchWeatherUi>

    @Binds
    @Singleton
    fun bindWeatherDomainToUiMapper(
        implementation: WeatherDomainToUiMapper
    ): Mapper<WeatherDomain, WeatherUi>

    @Binds
    @Singleton
    fun bindWeatherForFiveDaysDomainToUiMapper(
        implementation: WeatherForFiveDaysDomainToUiMapper
    ): Mapper<WeatherForFiveDaysDomain, WeatherForFiveDaysUi>

    @Binds
    @Singleton
    fun bindWeatherForFiveDaysResultDomainToUiMapper(
        implementation: WeatherForFiveDaysResultDomainToUiMapper
    ): Mapper<WeatherForFiveDaysResultDomain, WeatherForFiveDaysResultUi>

    @Binds
    @Singleton
    fun bindWeatherSystemInformationDomainToUiMapper(
        implementation: WeatherSystemInformationDomainToUiMapper
    ): Mapper<WeatherSystemInformationDomain, WeatherSystemInformationUi>

    @Binds
    @Singleton
    fun bindWeatherTemperatureDomainToUiMapper(
        implementation: WeatherTemperatureDomainToUiMapper
    ): Mapper<WeatherTemperatureDomain, WeatherTemperatureUi>

    @Binds
    @Singleton
    fun bindWindDomainToUIMapper(
        implementation: WindDomainToUIMapper
    ): Mapper<WindDomain, WindUi>
}