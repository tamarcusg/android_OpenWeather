package com.tamarcusg.openweather.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.tamarcusg.openweather.repository.model.Forecast
import com.tamarcusg.openweather.repository.model.WeatherDescription

internal class ForecastListPreviewProvider : CollectionPreviewParameterProvider<List<Forecast>>(
    listOf(
        listOf(
            Forecast(
                temperature = 20,
                feelsLike = 19,
                weatherDescriptions = listOf(
                    WeatherDescription(
                        description = "Clear",
                        detailedDescription = "broken clouds"
                    )
                )
            ),
            Forecast(
                temperature = 85,
                feelsLike = 100,
                weatherDescriptions = listOf(
                    WeatherDescription(
                        description = "Cloudy",
                        detailedDescription = "over cast clouds"
                    )
                )
            ),
            Forecast(
                temperature = 50,
                feelsLike = 59,
                weatherDescriptions = listOf(
                    WeatherDescription(
                        description = "Rain",
                        detailedDescription = "thunderstorms"
                    )
                )
            )

        )
    )
)