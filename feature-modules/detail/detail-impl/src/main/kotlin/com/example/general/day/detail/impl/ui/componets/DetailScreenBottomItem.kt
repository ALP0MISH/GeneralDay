package com.example.general.day.detail.impl.ui.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.general.day.ui.core.R.string
import com.example.general.day.detail.impl.ui.DetailUiState
import com.example.general.day.ui.core.theme.AddCityColor
import com.example.general.day.ui.core.theme.Gray
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp19
import com.example.general.day.ui.core.theme.dp24
import com.example.general.day.ui.core.theme.dp4
import com.example.general.day.ui.core.theme.sp11
import com.example.general.day.ui.core.theme.sp12
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.extensions.format
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.Line
import ir.ehsannarmani.compose_charts.models.PopupProperties

@Composable
fun DetailScreenBottomItem(
    modifier: Modifier = Modifier,
    uiState: DetailUiState.Loaded
) {
    Box(
        modifier = modifier
            .padding(bottom = dp19)
            .clip(RoundedCornerShape(dp24))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(dp16)
    ) {
        val temperatures = uiState.weatherForFiveDays.listTemperature
        val times = uiState.weatherForFiveDays.listTime

        if (temperatures.size > 1 && times.size > 1) {
            LineChart(
                modifier = Modifier.fillMaxWidth(),
                data = listOf(
                    Line(
                        drawStyle = DrawStyle.Stroke(dp4),
                        values = temperatures,
                        color = SolidColor(AddCityColor),
                        firstGradientFillColor = AddCityColor.copy(alpha = .5f),
                        secondGradientFillColor = Color.Transparent,
                        label = String()
                    )
                ),
                indicatorProperties = HorizontalIndicatorProperties(
                    textStyle = TextStyle(
                        color = Gray,
                        fontSize = sp12,
                    ),
                    contentBuilder = {
                        it.format(1) + " °C"
                    },
                ),
                popupProperties = PopupProperties(
                    textStyle = TextStyle(
                        fontSize = sp12,
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    contentBuilder = {
                        it.format(1) + " °C"
                    },
                    containerColor = MaterialTheme.colorScheme.background
                ),
                labelProperties = LabelProperties(
                    enabled = true,
                    textStyle = TextStyle(color = Gray),
                    labels = times,
                ),
                minValue = uiState.weatherForFiveDays.tempMin,
                maxValue = uiState.weatherForFiveDays.tempMax,
            )
        } else {
            Text(
                text = stringResource(id = string.not_enough_data_to_display),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }
}