package com.example.general.day.detail.impl.ui.componets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.general.day.detail.impl.ui.DetailUiState
import com.example.general.day.ui.components.helpers.kelvinToCelsius
import com.example.general.day.ui.components.helpers.toFormattedTime
import com.example.general.day.ui.core.theme.AddCityColor
import com.example.general.day.ui.core.theme.dp100
import com.example.general.day.ui.core.theme.dp16
import kotlin.random.Random

private const val STEPS = 10

@Composable
fun DetailScreenBottomItem(
    modifier: Modifier = Modifier,
    uiState: DetailUiState.Loaded
) {
    val popUpLabel: (Float, Float) -> (String) = { x, y ->
        val yLabel = "${String.format("%.1f", y)}"
        "$yLabel°"
    }

    val pointList = getPointsList(
        minTemperature = uiState.weatherForFiveDays.tempMin.kelvinToCelsius() ?: 16,
        maxTemperature = uiState.weatherForFiveDays.tempMax.kelvinToCelsius() ?: 20
    )
    val max = getMax(pointList)
    val min = getMin(pointList)
    val xAxisData = AxisData.Builder()
        .axisStepSize(dp100)
        .steps(pointList.size - 1)
        .labelData { uiState.weatherForFiveDays.time.toFormattedTime() }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(STEPS)
        .backgroundColor(color = Color.White)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = (max - min) / STEPS.toFloat()
            ((i * yScale) + min).toString()
        }.build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointList,
                    LineStyle(color = AddCityColor),
                    IntersectionPoint(color = MaterialTheme.colorScheme.onBackground),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.onBackground),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp(popUpLabel = popUpLabel)
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.White
    )
    LineChart(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dp16)),
        lineChartData = lineChartData
    )
}

fun getPointsList(maxTemperature: Int, minTemperature: Int): List<Point> {
    val list = ArrayList<Point>()

    for (i in 0..8) {
        val yValue = if (maxTemperature == minTemperature) {
            Random.nextInt(minTemperature, minTemperature + 4).toFloat()
        } else {
            Random.nextInt(minTemperature, maxTemperature).toFloat()
        }
        list.add(Point(i.toFloat(), yValue))
    }
    return list
}

private fun getMax(list: List<Point>): Float {
    var max = 0f
    list.forEach { point ->
        if (max < point.y) max = point.y
    }
    return max
}

private fun getMin(list: List<Point>): Float {
    var min = 100f
    list.forEach { point ->
        if (min > point.y) min = point.y
    }
    return min
}
