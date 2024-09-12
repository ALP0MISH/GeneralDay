package com.example.general.day.ui.core.utils

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.maps.android.clustering.ClusterItem

data class ZoneClusterItem(
    val id: String,
    val icon: Int,
    private val title: String,
    private val snippet: String,
    val polygonOptions: PolygonOptions
) : ClusterItem {

    override fun getSnippet() = snippet

    override fun getTitle() = title

    override fun getPosition(): LatLng = polygonOptions.points.getCenterOfPolygon().center
}