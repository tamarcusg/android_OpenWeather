package com.tamarcusg.openweather.forecast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.tamarcusg.openweather.preview.ForecastListPreviewProvider
import com.tamarcusg.openweather.preview.OpenWeatherPreview
import com.tamarcusg.openweather.repository.model.Forecast

@Composable
internal fun ForecastContent(
    modifier: Modifier = Modifier,
    uiState: ForecastUIState,
    onHandleEvent: (ForecastUIEvent) -> Unit
) {
    Column(modifier = modifier) {
        LazyColumn {
            items(uiState.forecasts.size) { index ->
                val forecast = uiState.forecasts[index]
                ForecastRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    forecast = forecast,
                    onClick = {
                        onHandleEvent(ForecastUIEvent.ForecastClicked(forecast))
                    }
                )
                if (index < uiState.forecasts.size - 1) {
                    HorizontalDivider()
                }
            }
        }
    }
}

@OpenWeatherPreview
@Composable
private fun ForecastContentPreview(
    @PreviewParameter(ForecastListPreviewProvider::class) forecastList: List<Forecast>
) {
    ForecastContent(
        uiState = ForecastUIState(
            forecasts = forecastList
        ),
        onHandleEvent = {}
    )
}