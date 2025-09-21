package com.tamarcusg.openweather.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.tamarcusg.openweather.R
import com.tamarcusg.openweather.preview.HomeContentPreviewData
import com.tamarcusg.openweather.preview.HomeContentPreviewProvider
import com.tamarcusg.openweather.preview.OpenWeatherPreview
import com.tamarcusg.openweather.repository.model.Forecast
import com.tamarcusg.openweather.util.LoadingState

@Composable
internal fun HomeContent(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onHandleEvent: (HomeUIEvent) -> Unit,
    onForecastLoaded: (List<Forecast>) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(uiState.loadingState) {
        if (uiState.loadingState is LoadingState.Loaded) {
            onForecastLoaded(uiState.loadingState.forecasts)
            onHandleEvent(HomeUIEvent.ResetState)
        }
    }

    Column(
        modifier = modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        if (uiState.loadingState is LoadingState.Error) {
            Text(
                text = stringResource(R.string.error_no_city, uiState.searchString),
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.searchString,
            placeholder = {
                Text(
                    text = stringResource(R.string.city_search_hint),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            onValueChange = {
                onHandleEvent(HomeUIEvent.SearchStringChanged(it))
            },
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = if (uiState.loadingState is LoadingState.Error) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.primary
                },
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onHandleEvent(HomeUIEvent.OnSearchClick)
                    keyboardController?.hide()
                }
            )
        )
        TextButton(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            onClick = { onHandleEvent(HomeUIEvent.OnSearchClick) },
            shape = RoundedCornerShape(percent = 25),
            border = BorderStroke(
                width = 1.dp,
                color = if (uiState.isSearchButtonEnabled) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                }
            ),
            enabled = uiState.isSearchButtonEnabled
        ) {
            if (uiState.loadingState is LoadingState.Loading) {
                CircularProgressIndicator()
            } else {
                Text(stringResource(R.string.city_search_button))
            }
        }
    }
}

@OpenWeatherPreview
@Composable
private fun HomeContentPreview(
    @PreviewParameter(HomeContentPreviewProvider::class) previewData: HomeContentPreviewData
) {
    HomeContent(
        uiState = HomeUIState(
            searchString = previewData.searchString,
            loadingState = previewData.loadingState
        ),
        onHandleEvent = {},
        onForecastLoaded = {}
    )
}