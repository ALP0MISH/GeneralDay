package com.example.general.day.data.models

import com.example.general.day.data.local.models.LocalCurrentWeatherResponse
import com.example.general.day.data.local.models.LocalCoord
import com.example.general.day.data.local.models.LocalClouds
import com.example.general.day.data.local.models.LocalSys
import com.example.general.day.data.local.models.LocalWeather
import com.example.general.day.data.local.models.LocalWind

data class CurrentWeatherResponse(
    val base: String,
    val localClouds: LocalClouds,
    val cod: Int,
    val localCoord: LocalCoord,
    val dt: Int,
    val id: Int,
    val localMain: LocalMain,
    val name: String,
    val localSys: LocalSys,
    val localWeather: List<LocalWeather>,
    val localWind: LocalWind
) {
    companion object {
        val unknown = LocalCurrentWeatherResponse(
            base = String(),
            localClouds = LocalClouds(all = -1),
            cod = -1,
            id = -1,
            localMain = Main.unknown,
            name = String(),
            localSys = LocalSys(pod = String()),
            localWeather = emptyList(),
            localWind = LocalWind(deg = -1, speed = 0.0),
            localCoord = LocalCoord(lat = 0.0, lon = 0.0),
            dt = -1
        )
    }
}