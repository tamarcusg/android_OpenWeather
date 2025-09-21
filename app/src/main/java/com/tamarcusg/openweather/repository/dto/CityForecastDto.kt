package com.tamarcusg.openweather.repository.dto

import com.tamarcusg.openweather.repository.model.CityForecast
import com.tamarcusg.openweather.repository.model.Forecast
import com.tamarcusg.openweather.repository.model.WeatherDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CityForecastDto(
    @SerialName("list")
    val forecasts: List<ForecastDto>
) {
    fun toDomain() = CityForecast(
        forecasts = forecasts.map { forecastDto ->
            Forecast(
                temperature = forecastDto.temperature.temp,
                feelsLike = forecastDto.temperature.feelsLike,
                weatherDescriptions = forecastDto.weatherDescriptions.map { weatherDescriptionDto ->
                    WeatherDescription(
                        description = weatherDescriptionDto.description,
                        detailedDescription = weatherDescriptionDto.detailedDescription
                    )
                }
            )
        }
    )
}