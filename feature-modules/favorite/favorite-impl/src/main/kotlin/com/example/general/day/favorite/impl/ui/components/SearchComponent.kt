package com.example.general.day.favorite.impl.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.general.day.favorite.impl.ui.FavoriteEvent
import com.example.general.day.ui.core.R.string
import com.example.general.day.ui.core.theme.dp16

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    value: String,
    onEvent: (FavoriteEvent) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = {
            onEvent(FavoriteEvent.DoSavedWeatherOnValueChange(it))
        },
        colors = TextFieldDefaults.colors(
            disabledTextColor = MaterialTheme.colorScheme.onBackground,
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            focusedContainerColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            focusedLabelColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent,
            disabledLabelColor = Color.Transparent,
            focusedSuffixColor = Color.Transparent,
            unfocusedSuffixColor = Color.Transparent,
            unfocusedPrefixColor = Color.Transparent,
            focusedPrefixColor = Color.Transparent,
            disabledPrefixColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        minLines = 1,
        placeholder = {
            Text(
                text = stringResource(id = string.search_sity),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        },
        leadingIcon = {
            Icon(
                modifier = Modifier,
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.05f)
            .padding(top = dp16)
    )
}

@Preview
@Composable
fun SearchComponentPreview() {
    SearchComponent(
        value = String(),
        onEvent = {},
    )
}