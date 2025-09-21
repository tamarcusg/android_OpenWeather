package com.tamarcusg.openweather.forecast

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.tamarcusg.openweather.R
import com.tamarcusg.openweather.preview.ForecastListPreviewProvider
import com.tamarcusg.openweather.preview.OpenWeatherPreview
import com.tamarcusg.openweather.repository.model.Forecast

@Composable
internal fun ForecastRow(
    modifier: Modifier = Modifier,
    forecast: Forecast,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 36.dp, vertical = 12.dp),
    ) {
        Text(forecast.weatherDescriptions.first().description)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            stringResource(R.string.label_temperature, forecast.temperature)
        )
    }
}

@OpenWeatherPreview
@Composable
private fun ForecastRowPreview(
    @PreviewParameter(ForecastListPreviewProvider::class) forecastList: List<Forecast>
) {
    ForecastRow(
        forecast = forecastList.first(),
        onClick = {}
    )
}