package com.example.general.day.ui.core.utils

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

private const val VIEW_MODEL_CANNOT_BE_NULL = "viewCoord не может быть нулевым"
private const val CANNOT_CALCULATE_NOTHING = "Не удается вычислить координаты точки обзора ничего."

fun List<LatLng>.getCenterOfPolygon(): LatLngBounds {
    val centerBuilder: LatLngBounds.Builder = LatLngBounds.builder()
    forEach { centerBuilder.include(LatLng(it.latitude, it.longitude)) }
    return centerBuilder.build()
}

private data class CameraViewCoord(
    val yMax: Double,
    val yMin: Double,
    val xMax: Double,
    val xMin: Double
)

fun List<LatLng>.calculateCameraViewPoints(pctView: Double = .25): List<LatLng> {
    val coordMax = findMaxMins()
    val dy = coordMax.yMax - coordMax.yMin
    val dx = coordMax.xMax - coordMax.xMin
    val yT = (dy * pctView) + coordMax.yMax
    val yB = coordMax.yMin - (dy * pctView)
    val xR = (dx * pctView) + coordMax.xMax
    val xL = coordMax.xMin - (dx * pctView)
    return listOf(
        LatLng(coordMax.xMax, yT),
        LatLng(coordMax.xMin, yB),
        LatLng(xR, coordMax.yMax),
        LatLng(xL, coordMax.yMin)
    )
}

private fun List<LatLng>.findMaxMins(): CameraViewCoord {
    check(size > 0) { CANNOT_CALCULATE_NOTHING }
    var viewCoord: CameraViewCoord? = null
    for (point in this) {
        viewCoord = CameraViewCoord(
            yMax = viewCoord?.yMax?.let { yMax ->
                if (point.longitude > yMax) {
                    point.longitude
                } else {
                    yMax
                }
            } ?: point.longitude,
            yMin = viewCoord?.yMin?.let { yMin ->
                if (point.longitude < yMin) {
                    point.longitude
                } else {
                    yMin
                }
            } ?: point.longitude,
            xMax = viewCoord?.xMax?.let { xMax ->
                if (point.latitude > xMax) {
                    point.latitude
                } else {
                    xMax
                }
            } ?: point.latitude,
            xMin = viewCoord?.xMin?.let { xMin ->
                if (point.latitude < xMin) {
                    point.latitude
                } else {
                    xMin
                }
            } ?: point.latitude,
        )
    }
    return viewCoord ?: throw IllegalStateException(VIEW_MODEL_CANNOT_BE_NULL)
}