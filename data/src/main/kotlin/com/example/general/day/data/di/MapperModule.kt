package com.example.general.day.data.di

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CityCloud
import com.example.general.day.data.cloud.models.CloudsCloud
import com.example.general.day.data.cloud.models.CoordinatesCloud
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.ForRainOrSnowCloud
import com.example.general.day.data.cloud.models.WeatherCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.cloud.models.WeatherSystemInformationCloud
import com.example.general.day.data.cloud.models.WeatherTemperatureCloud
import com.example.general.day.data.cloud.models.WindCloud
import com.example.general.day.data.local.models.CurrentWeatherLocal
import com.example.general.day.data.cloud.mapper.CoordinatesCloudToCoordinatesDataMapper
import com.example.general.day.data.cloud.mapper.CurrentWeatherCloudToCurrentWeatherDataMapper
import com.example.general.day.data.cloud.mapper.ForRainOrSnowCloudToForRainOrSnowDataMapper
import com.example.general.day.data.cloud.mapper.WeatherCloudToWeatherDataMapper
import com.example.general.day.data.cloud.mapper.WeatherForFiveDaysResultCloudToWeatherForFiveDaysDataMapper
import com.example.general.day.data.mappers.CityDataToCityDomainMapper
import com.example.general.day.data.mappers.CloudsDataToDomainMapper
import com.example.general.day.data.mappers.WindDataToWindDomainMapper
import com.example.general.day.data.mappers.CurrentWeatherLocalDataToCurrentWeatherLocalDomainMapper
import com.example.general.day.data.models.CityData
import com.example.general.day.data.models.CloudsData
import com.example.general.day.data.models.CoordinatesData
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.CurrentWeatherLocalData
import com.example.general.day.data.models.ForRainOrSnowData
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
    fun bindsCityCloudToCityDataMapper(
        implementation: CityCloudToCityDataMapper
    ): Mapper<CityCloud, CityData>

    @Binds
    fun bindsCloudsCloudToCloudsDataMapper(
        implementation: CloudsCloudToCloudsDataMapper
    ): Mapper<CloudsCloud, CloudsData>

    @Binds
    fun bindsCoordinatesCloudToCoordinatesDataMapper(
        implementation: CoordinatesCloudToCoordinatesDataMapper
    ): Mapper<CoordinatesCloud, CoordinatesData>

    @Binds
    fun bindsCurrentWeatherCloudToCurrentWeatherDataMapper(
        implementation: CurrentWeatherCloudToCurrentWeatherDataMapper
    ): Mapper<CurrentWeatherResponseCloud, CurrentWeatherData>

    @Binds
    fun bindsForRainOrSnowCloudToForRainOrSnowDataMapper(
        implementation: ForRainOrSnowCloudToForRainOrSnowDataMapper
    ): Mapper<ForRainOrSnowCloud, ForRainOrSnowData>

    @Binds
    fun bindsWeatherCloudToWeatherDataMapper(
        implementation: WeatherCloudToWeatherDataMapper
    ): Mapper<WeatherCloud, WeatherData>

    @Binds
    fun bindsWeatherForFiveDaysResponseCloudToWeatherForFiveDaysDataMapper(
        implementation: WeatherForFiveDaysResponseCloudToWeatherForFiveDaysDataMapper
    ): Mapper<WeatherForFiveDaysResponseCloud, WeatherForFiveDaysData>

    @Binds
    fun bindsWeatherForFiveDaysResultCloudToWeatherForFiveDaysDataMapper(
        implementation: WeatherForFiveDaysResultCloudToWeatherForFiveDaysDataMapper
    ): Mapper<WeatherForFiveDaysResultCloud, WeatherForFiveDaysResultData>

    @Binds
    fun bindsWeatherSystemInformationCloudToWeatherSystemInformationDataMapper(
        implementation: WeatherSystemInformationCloudToWeatherSystemInformationDataMapper
    ): Mapper<WeatherSystemInformationCloud, WeatherSystemInformationData>

    @Binds
    fun bindsWeatherTemperatureCloudToWeatherTemperatureDataMapper(
        implementation: WeatherTemperatureCloudToWeatherTemperatureDataMapper
    ): Mapper<WeatherTemperatureCloud, WeatherTemperatureData>

    @Binds
    fun bindsWindCloudToWindDataMapper(
        implementation: WindCloudToWindDataMapper
    ): Mapper<WindCloud, WindData>

    @Binds
    fun bindsCityDataToCityDomainMapper(
        implementation: CityDataToCityDomainMapper
    ): Mapper<CityData, CityDomain>

    @Binds
    fun bindsCloudsDataToCloudsDomainMapper(
        implementation: CloudsDataToDomainMapper
    ): Mapper<CloudsData, CloudsDomain>

    @Binds
    fun bindsCoordinatesDataToCoordinatesDomainMapper(
        implementation: CoordinatesDataToCoordinatesDomainMapper
    ): Mapper<CoordinatesData, CoordinatesDomain>

    @Binds
    fun bindsCurrentWeatherDataToCurrentWeatherDomainMapper(
        implementation: CurrentWeatherDataToCurrentWeatherDomainMapper
    ): Mapper<CurrentWeatherData, CurrentWeatherDomain>

    @Binds
    fun bindsCurrentWeatherLocalDataToCurrentWeatherLocalDomainMapper(
        implementation: CurrentWeatherLocalDataToCurrentWeatherLocalDomainMapper
    ): Mapper<CurrentWeatherLocalData, CurrentWeatherLocalDomain>

    @Binds
    fun bindsForRainOrSnowDataToForRainOrSnowDomainMapper(
        implementation: ForRainOrSnowDataToForRainOrSnowDomainMapper
    ): Mapper<ForRainOrSnowData, ForRainOrSnowDomain>

    @Binds
    fun bindsWeatherDataToWeatherDomainMapper(
        implementation: WeatherDataToWeatherDomainMapper
    ): Mapper<WeatherData, WeatherDomain>

    @Binds
    fun bindsWeatherForFiveDaysResponseDataToWeatherForFiveDaysDomainMapper(
        implementation: WeatherForFiveDaysResponseDataToWeatherForFiveDaysDomainMapper
    ): Mapper<WeatherForFiveDaysData, WeatherForFiveDaysDomain>

    @Binds
    fun bindsWeatherForFiveDaysResultDataToWeatherForFiveDaysDomainMapper(
        implementation: WeatherForFiveDaysResultDataToWeatherForFiveDaysDomainMapper
    ): Mapper<WeatherForFiveDaysResultData, WeatherForFiveDaysResultDomain>

    @Binds
    fun bindsWeatherSystemInformationDataToWeatherSystemInformationDomainMapper(
        implementation: WeatherSystemInformationDataToWeatherSystemInformationDomainMapper
    ): Mapper<WeatherSystemInformationData, WeatherSystemInformationDomain>

    @Binds
    fun bindsWeatherTemperatureDataToWeatherTemperatureDomainMapper(
        implementation: WeatherTemperatureDataToWeatherTemperatureDomainMapper
    ): Mapper<WeatherTemperatureData, WeatherTemperatureDomain>

    @Binds
    fun bindsWindDataToWindDomainMapper(
        implementation: WindDataToWindDomainMapper
    ): Mapper<WindData, WindDomain>

    @Binds
    fun bindsCurrentWeatherDomainToCurrentWeatherDataMapper(
        implementation: CurrentWeatherDomainToCurrentWeatherDataMapper
    ): Mapper<CurrentWeatherLocalDomain, CurrentWeatherLocalData>

    @Binds
    fun bindsCurrentWeatherLocalToCurrentWeatherDataMapper(
        implementation: CurrentWeatherLocalToCurrentWeatherDataMapper
    ): Mapper<CurrentWeatherLocal, CurrentWeatherLocalData>
}