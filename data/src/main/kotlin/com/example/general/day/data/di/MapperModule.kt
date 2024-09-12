package com.example.general.day.data.di

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.mapper.CityCloudToDataMapper
import com.example.general.day.data.cloud.mapper.CloudsCloudToDataMapper
import com.example.general.day.data.cloud.mapper.CoordinatesCloudToDataMapper
import com.example.general.day.data.cloud.mapper.CurrentWeatherCloudToDataMapper
import com.example.general.day.data.cloud.mapper.ForRainOrSnowCloudToDataMapper
import com.example.general.day.data.cloud.mapper.LocalNameCloudToDataMapper
import com.example.general.day.data.cloud.mapper.SearchWeatherCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WeatherCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WeatherForFiveDaysResponseCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WeatherForFiveDaysResultCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WeatherSystemInformationCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WeatherTemperatureCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WindCloudToDataMapper
import com.example.general.day.data.cloud.models.CityCloud
import com.example.general.day.data.cloud.models.CloudsCloud
import com.example.general.day.data.cloud.models.CoordinatesCloud
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.ForRainOrSnowCloud
import com.example.general.day.data.cloud.models.LocalNamesCloud
import com.example.general.day.data.cloud.models.SearchWeatherCloud
import com.example.general.day.data.cloud.models.WeatherCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.cloud.models.WeatherSystemInformationCloud
import com.example.general.day.data.cloud.models.WeatherTemperatureCloud
import com.example.general.day.data.cloud.models.WindCloud
import com.example.general.day.data.local.mapper.CurrentWeatherLocalToDataMapper
import com.example.general.day.data.local.models.CurrentWeatherLocal
import com.example.general.day.data.mappers.CityDataToCityDomainMapper
import com.example.general.day.data.mappers.CloudsDataToDomainMapper
import com.example.general.day.data.mappers.CoordinatesDataToDomainMapper
import com.example.general.day.data.mappers.CurrentWeatherDataToDomainMapper
import com.example.general.day.data.mappers.CurrentWeatherDomainToDataMapper
import com.example.general.day.data.mappers.CurrentWeatherLocalDataToDomainMapper
import com.example.general.day.data.mappers.ForRainOrSnowDataToDomainMapper
import com.example.general.day.data.mappers.LocalNameDataToDomainMapper
import com.example.general.day.data.mappers.SearchWeatherDataToDomainMapper
import com.example.general.day.data.mappers.WeatherDataToDomainMapper
import com.example.general.day.data.mappers.WeatherForFiveDaysDataToDomainMapper
import com.example.general.day.data.mappers.WeatherForFiveDaysResultDataToDomainMapper
import com.example.general.day.data.mappers.WeatherSystemInformationDataToDomainMapper
import com.example.general.day.data.mappers.WeatherTemperatureDataToDomainMapper
import com.example.general.day.data.mappers.WindDataToDomainMapper
import com.example.general.day.data.models.CityData
import com.example.general.day.data.models.CloudsData
import com.example.general.day.data.models.CoordinatesData
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.CurrentWeatherLocalData
import com.example.general.day.data.models.ForRainOrSnowData
import com.example.general.day.data.models.LocalNamesData
import com.example.general.day.data.models.SearchWeatherData
import com.example.general.day.data.models.WeatherData
import com.example.general.day.data.models.WeatherForFiveDaysData
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import com.example.general.day.data.models.WeatherSystemInformationData
import com.example.general.day.data.models.WeatherTemperatureData
import com.example.general.day.data.models.WindData
import com.example.general.day.domain.models.CityDomain
import com.example.general.day.domain.models.CloudsDomain
import com.example.general.day.domain.models.CoordinatesDomain
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.CurrentWeatherLocalDomain
import com.example.general.day.domain.models.ForRainOrSnowDomain
import com.example.general.day.domain.models.LocalNamesDomain
import com.example.general.day.domain.models.SearchWeatherDomain
import com.example.general.day.domain.models.WeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain
import com.example.general.day.domain.models.WeatherForFiveDaysResultDomain
import com.example.general.day.domain.models.WeatherSystemInformationDomain
import com.example.general.day.domain.models.WeatherTemperatureDomain
import com.example.general.day.domain.models.WindDomain
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun bindsCityCloudToDataMapper(
        implementation: CityCloudToDataMapper
    ): Mapper<CityCloud, CityData>

    @Binds
    fun bindsLocalNameCloudToDataMapper(
        implementation: LocalNameCloudToDataMapper
    ): Mapper<LocalNamesCloud, LocalNamesData>

    @Binds
    fun bindsLocalNameDataToDomainMapper(
        implementation: LocalNameDataToDomainMapper
    ): Mapper<LocalNamesData, LocalNamesDomain>

    @Binds
    fun bindsCloudsCloudToDataMapper(
        implementation: CloudsCloudToDataMapper
    ): Mapper<CloudsCloud, CloudsData>

    @Binds
    fun bindsCoordinatesCloudToDataMapper(
        implementation: CoordinatesCloudToDataMapper
    ): Mapper<CoordinatesCloud, CoordinatesData>

    @Binds
    fun bindsCurrentWeatherCloudToDataMapper(
        implementation: CurrentWeatherCloudToDataMapper
    ): Mapper<CurrentWeatherResponseCloud, CurrentWeatherData>

    @Binds
    fun bindsForRainOrSnowCloudToDataMapper(
        implementation: ForRainOrSnowCloudToDataMapper
    ): Mapper<ForRainOrSnowCloud, ForRainOrSnowData>

    @Binds
    fun bindsWeatherCloudToDataMapper(
        implementation: WeatherCloudToDataMapper
    ): Mapper<WeatherCloud, WeatherData>

    @Binds
    fun bindsWeatherForFiveDaysResponseCloudToDataMapper(
        implementation: WeatherForFiveDaysResponseCloudToDataMapper
    ): Mapper<WeatherForFiveDaysResponseCloud, WeatherForFiveDaysData>

    @Binds
    fun bindsWeatherForFiveDaysResultCloudToDataMapper(
        implementation: WeatherForFiveDaysResultCloudToDataMapper
    ): Mapper<WeatherForFiveDaysResultCloud, WeatherForFiveDaysResultData>

    @Binds
    fun bindsWeatherSystemInformationCloudToDataMapper(
        implementation: WeatherSystemInformationCloudToDataMapper
    ): Mapper<WeatherSystemInformationCloud, WeatherSystemInformationData>

    @Binds
    fun bindsWeatherTemperatureCloudToDataMapper(
        implementation: WeatherTemperatureCloudToDataMapper
    ): Mapper<WeatherTemperatureCloud, WeatherTemperatureData>

    @Binds
    fun bindsWindCloudToDataMapper(
        implementation: WindCloudToDataMapper
    ): Mapper<WindCloud, WindData>

    @Binds
    fun bindsCityDataToCityDomainMapper(
        implementation: CityDataToCityDomainMapper
    ): Mapper<CityData, CityDomain>

    @Binds
    fun bindsCloudsDataToDomainMapper(
        implementation: CloudsDataToDomainMapper
    ): Mapper<CloudsData, CloudsDomain>

    @Binds
    fun bindsCoordinatesDataToDomainMapper(
        implementation: CoordinatesDataToDomainMapper
    ): Mapper<CoordinatesData, CoordinatesDomain>

    @Binds
    fun bindsCurrentWeatherDataToDomainMapper(
        implementation: CurrentWeatherDataToDomainMapper
    ): Mapper<CurrentWeatherData, CurrentWeatherDomain>

    @Binds
    fun bindsCurrentWeatherLocalDataToDomainMapper(
        implementation: CurrentWeatherLocalDataToDomainMapper
    ): Mapper<CurrentWeatherLocalData, CurrentWeatherLocalDomain>

    @Binds
    fun bindsForRainOrSnowDataToDomainMapper(
        implementation: ForRainOrSnowDataToDomainMapper
    ): Mapper<ForRainOrSnowData, ForRainOrSnowDomain>

    @Binds
    fun bindsWeatherDataToDomainMapper(
        implementation: WeatherDataToDomainMapper
    ): Mapper<WeatherData, WeatherDomain>

    @Binds
    fun bindsWeatherForFiveDaysDataToDomainMapper(
        implementation: WeatherForFiveDaysDataToDomainMapper
    ): Mapper<WeatherForFiveDaysData, WeatherForFiveDaysDomain>

    @Binds
    fun bindsWeatherForFiveDaysResultDataToDomainMapper(
        implementation: WeatherForFiveDaysResultDataToDomainMapper
    ): Mapper<WeatherForFiveDaysResultData, WeatherForFiveDaysResultDomain>

    @Binds
    fun bindsWeatherSystemInformationDataToDomainMapper(
        implementation: WeatherSystemInformationDataToDomainMapper
    ): Mapper<WeatherSystemInformationData, WeatherSystemInformationDomain>

    @Binds
    fun bindsWeatherTemperatureDataToDomainMapper(
        implementation: WeatherTemperatureDataToDomainMapper
    ): Mapper<WeatherTemperatureData, WeatherTemperatureDomain>

    @Binds
    fun bindsWindDataToDomainMapper(
        implementation: WindDataToDomainMapper
    ): Mapper<WindData, WindDomain>

    @Binds
    fun bindsCurrentWeatherDomainToDataMapper(
        implementation: CurrentWeatherDomainToDataMapper
    ): Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalData>

    @Binds
    fun bindsCurrentWeatherLocalToDataMapper(
        implementation: CurrentWeatherLocalToDataMapper
    ): Mapper<CurrentWeatherLocal, CurrentWeatherLocalData>

    @Binds
    fun bindsSearchWeatherCloudToDataMapper(
        implementation: SearchWeatherCloudToDataMapper
    ): Mapper<SearchWeatherCloud, SearchWeatherData>

    @Binds
    fun bindsSearchWeatherDataToDomainMapper(
        implementation: SearchWeatherDataToDomainMapper
    ): Mapper<SearchWeatherData, SearchWeatherDomain>
}