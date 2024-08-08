package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherSystemInformationCloud
import com.example.general.day.data.models.WeatherSystemInformationData
import javax.inject.Inject

class WeatherSystemInformationCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherSystemInformationCloud, @JvmSuppressWildcards WeatherSystemInformationData> {
    override fun map(from: WeatherSystemInformationCloud): WeatherSystemInformationData =
        from.run {
            WeatherSystemInformationData(
                partOfDay = partOfDay.orEmpty(),
                sunset = sunset,
                sunrise = sunrise
            )
        }
}