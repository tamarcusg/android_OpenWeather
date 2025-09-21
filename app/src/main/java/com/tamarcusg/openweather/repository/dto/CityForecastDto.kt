package com.tamarcusg.openweather.repository.dto

import com.tamarcusg.openweather.repository.model.Forecast
import com.tamarcusg.openweather.repository.model.WeatherDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.roundToInt

@Serializable
internal data class CityForecastDto(
    @SerialName("list")
    val forecasts: List<ForecastDto>
) {
    fun toDomain() = forecasts.map { forecastDto ->
        Forecast(
            temperature = forecastDto.temperature.temp.roundToInt(),
            feelsLike = forecastDto.temperature.feelsLike.roundToInt(),
            weatherDescriptions = forecastDto.weatherDescriptions.map { weatherDescriptionDto ->
                WeatherDescription(
                    description = weatherDescriptionDto.description,
                    detailedDescription = weatherDescriptionDto.detailedDescription
                )
            }
        )
    }
}