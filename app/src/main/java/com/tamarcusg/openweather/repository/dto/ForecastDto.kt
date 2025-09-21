package com.tamarcusg.openweather.repository.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ForecastDto(
    @SerialName("main")
    val temperature: TemperatureDto,
    @SerialName("weather")
    val weatherDescriptions: List<WeatherDescriptionDto>
)