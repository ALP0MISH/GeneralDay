package com.example.general.day.map.api

import com.example.general.day.core.FeatureApi

interface MapFeatureUiApi : FeatureApi {

    val mapRouteProvider: MapRouteProvider
}