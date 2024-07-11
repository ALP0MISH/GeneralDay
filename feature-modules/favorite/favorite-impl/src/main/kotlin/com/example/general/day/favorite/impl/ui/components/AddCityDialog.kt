package com.example.general.day.favorite.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.general.day.favorite.impl.ui.FavoriteEvent
import com.example.general.day.favorite.impl.ui.FavoriteUIState
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.theme.AddCityColor
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp22
import com.example.general.day.ui.core.theme.dp8

@Composable
fun AddCityDialog(
    cityName: String,
    onEvent: (FavoriteEvent) -> Unit,
    onDismissRequest: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val filteredCities = listOf("Москва", "Минск", "Мурманск", "Моршанск")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dp16)
            .background(
                MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium
            )
            .padding(dp16)
    ) {
        BasicTextField(
            value = cityName,
            onValueChange = { onEvent(FavoriteEvent.GetCityName(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp8)
                .background(
                    Color.Gray.copy(alpha = 0.1f),
                    shape = MaterialTheme.shapes.small
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(Modifier.weight(1f)) {
                        if (cityName.isEmpty()) {
                            Text(
                                text = stringResource(id = string.search_sity),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        innerTextField()
                    }
                    if (cityName.isNotEmpty()) {
                        IconButton(
                            onClick = { onEvent(FavoriteEvent.GetCityName(""),) },
                        ) {
                            Icon(
                                modifier = Modifier.size(dp22),
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(filteredCities) { city ->
                Text(
                    text = city,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            onEvent(FavoriteEvent.GetCityName(city))
                        }
                        .background(
                            MaterialTheme.colorScheme.secondary,
                            shape = MaterialTheme.shapes.small
                        ),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onDismissRequest,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = stringResource(id = string.сancel),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray
                )
            }
            Button(
                onClick = { onAddClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AddCityColor
                )
            ) {
                Text(
                    text = stringResource(id = string.add),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                )
            }
        }
    }
}