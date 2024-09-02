package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.LocalNamesCloud
import com.example.general.day.data.cloud.models.SearchWeatherCloud
import com.example.general.day.data.models.LocalNamesData
import com.example.general.day.data.models.SearchWeatherData
import javax.inject.Inject

class SearchWeatherCloudToDataMapper @Inject constructor(
    private val localNameCloudToDataMapper: @JvmSuppressWildcards Mapper<LocalNamesCloud?, LocalNamesData>
) : Mapper<@JvmSuppressWildcards SearchWeatherCloud, @JvmSuppressWildcards SearchWeatherData> {
    override fun map(from: SearchWeatherCloud): SearchWeatherData = from.run {
        SearchWeatherData(
            country = country,
            lat = lat,
            lon = lon,
            name = name,
            state = state,
            localNames = localNameCloudToDataMapper.map(localNames)
        )
    }
}