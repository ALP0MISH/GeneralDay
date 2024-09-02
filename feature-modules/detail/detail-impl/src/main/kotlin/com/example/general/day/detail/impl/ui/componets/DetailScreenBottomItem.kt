package com.example.general.day.detail.impl.ui.componets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.general.day.detail.impl.ui.DetailUiState
import com.example.general.day.ui.components.helpers.toFormattedTime
import kotlin.math.roundToInt

@Composable
fun DetailScreenBottomItem(
    modifier: Modifier = Modifier,
    uiState: DetailUiState.Loaded
) {
    val temperaturesList =
        uiState.weatherForFiveDays.temperature.split(",").map { it.toFloatOrNull() ?: 0f }
    val timesList = uiState.weatherForFiveDays.time.toFormattedTime().split(",")
    val weatherIconsList = uiState.weatherForFiveDays.weatherIcon

    val spacing = 100.dp
    val iconSize = 40.dp
    val iconOffsetY = 20.dp
    val chartHeight = 200.dp

    val density = LocalDensity.current

    val spacingPx = with(density) { spacing.toPx() }
    val iconOffsetYPx = with(density) { iconOffsetY.toPx() }
    val chartHeightPx = with(density) { chartHeight.toPx() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFE6EBF4))
            .padding(16.dp)
    ) {
        Box(modifier = Modifier.height(chartHeight)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                if (temperaturesList.isNotEmpty()) {
                    val path = Path().apply {
                        moveTo(0f, size.height - temperaturesList[0])
                        temperaturesList.forEachIndexed { index, temp ->
                            val x = index * spacingPx
                            val y = size.height - temp.coerceIn(0f, size.height)
                            lineTo(x, y)
                        }
                    }
                    drawPath(
                        path = path,
                        color = Color(0xFF4A90E2),
                        style = Stroke(width = with(density) { 4.dp.toPx() })
                    )
                }
            }

            if (temperaturesList.isNotEmpty()) {
                val lastIndex = temperaturesList.size - 1
                val iconPositionPx = Offset(
                    x = lastIndex * spacingPx,
                    y = chartHeightPx - temperaturesList[lastIndex] - iconOffsetYPx
                )

                val iconPosition = Modifier.offset(
                    x = with(density) { iconPositionPx.x.toDp() } - (iconSize / 2),
                    y = with(density) { iconPositionPx.y.toDp() } - iconSize
                )

                Box(
                    modifier = iconPosition
                        .size(iconSize)
                        .background(Color.White, shape = MaterialTheme.shapes.medium)
                        .align(Alignment.TopStart)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = weatherIconsList),
                            contentDescription = null,
                            modifier = Modifier.size(iconSize)
                        )
                        Text(
                            text = "${temperaturesList.getOrElse(lastIndex) { 0f }.roundToInt()}°",
                            style = TextStyle(color = Color.Black, fontSize = 18.sp)
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            timesList.forEach { time ->
                Text(
                    text = time,
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                )
            }
        }
    }
}
