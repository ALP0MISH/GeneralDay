package com.example.general.day.home.impl.ui.items

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.general.day.ui.core.threme.dp100
import com.example.general.day.ui.core.threme.dp16
import com.example.general.day.ui.core.threme.sp48

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    dayAndTime: String,
    currentTemperature: String,
    feelsLikeTemperature: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dp16)
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopCenter),
            text = dayAndTime,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        Icon(
            modifier = Modifier.size(dp100).align(Alignment.Center),
            imageVector = Icons.Default.Star,
            contentDescription = null,
        )
        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = currentTemperature,
            fontSize = sp48,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = feelsLikeTemperature,
            style = MaterialTheme.typography.titleSmall,
            color = Color.White,
        )
    }
}