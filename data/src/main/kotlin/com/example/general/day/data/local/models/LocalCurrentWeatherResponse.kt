package com.example.general.day.data.local.models

import com.example.general.day.data.models.CurrentWeatherResponse
import com.example.general.day.data.models.LocalMain

data class LocalCurrentWeatherResponse(
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
        val unknown = CurrentWeatherResponse(
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