package com.tamarcusg.openweather.forecast.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tamarcusg.openweather.R
import com.tamarcusg.openweather.preview.ForecastListPreviewProvider
import com.tamarcusg.openweather.preview.OpenWeatherPreview
import com.tamarcusg.openweather.repository.model.Forecast

@Composable
internal fun ForecastDetailsContent(
    modifier: Modifier = Modifier,
    forecast: Forecast,
    onCloseClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.End),
            onClick = onCloseClick,
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(R.string.cd_close_button)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = forecast.temperature.toString(),
                fontSize = 100.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.label_feels_like, forecast.feelsLike),
                fontSize = 30.sp,
                textAlign = TextAlign.End
            )
            forecast.weatherDescriptions.forEach { item ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Text(
                        text = item.description,
                        fontSize = 40.sp
                    )
                    Text(
                        text = item.detailedDescription,
                        fontSize = 25.sp

                    )
                }
            }
        }
    }
}

@OpenWeatherPreview
@Composable
private fun ForecastDetailsContentPreview(
    @PreviewParameter(ForecastListPreviewProvider::class) forecastList: List<Forecast>
) {
    ForecastDetailsContent(
        forecast = forecastList.first(),
        onCloseClick = {}
    )
}