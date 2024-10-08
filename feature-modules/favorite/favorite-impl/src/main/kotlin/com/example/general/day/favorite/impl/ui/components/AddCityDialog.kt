package com.example.general.day.favorite.impl.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import com.example.general.day.favorite.impl.ui.FavoriteEvent
import com.example.general.day.favorite.impl.ui.FavoriteUIState
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.theme.AddCityColor
import com.example.general.day.ui.core.theme.dp12
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp22
import com.example.general.day.ui.core.theme.dp24
import com.example.general.day.ui.core.theme.dp4
import com.example.general.day.ui.core.theme.dp8
import com.example.general.day.ui.core.theme.sp14

@Composable
fun AddCityDialog(
    value: String,
    onEvent: (FavoriteEvent) -> Unit,
    onAddClick: () -> Unit,
    onDismissRequest: () -> Unit,
    uiState: FavoriteUIState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BasicTextField(
            value = value,
            onValueChange = { onEvent(FavoriteEvent.GetCityName(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dp16, start = dp16, end = dp16)
                .background(
                    Color.Gray.copy(alpha = 0.1f),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(dp8),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = sp14
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(dp24)
                    )
                    Spacer(modifier = Modifier.width(dp8))
                    Box(Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = stringResource(id = string.search_sity),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        innerTextField()
                    }
                    if (value.isNotEmpty()) {
                        IconButton(
                            modifier = Modifier.size(dp22),
                            onClick = {
                                onEvent(FavoriteEvent.GetCityName(String()))
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(dp16))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            if (uiState.query.isNotEmpty()) {
                items(uiState.searchResult.filter { city -> city.localName.ru.isNotEmpty() }) { city ->
                    Text(
                        text = city.localName.ru,
                        modifier = Modifier
                            .padding(start = dp12)
                            .clickable {
                                onEvent(FavoriteEvent.GetCityName(city.localName.ru))
                            }
                            .background(
                                Color.Gray.copy(alpha = 0.1f),
                                shape = MaterialTheme.shapes.small
                            )
                            .padding(dp4),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(dp16))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp16),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onDismissRequest,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(dp12)
            ) {
                Text(
                    text = stringResource(id = string.сancel),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = {
                    onAddClick()
                    onEvent(FavoriteEvent.DoFetchCityName)
                },
                colors = ButtonDefaults.buttonColors(containerColor = AddCityColor),
                shape = RoundedCornerShape(dp12)
            ) {
                Text(
                    text = stringResource(id = string.confirm),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
