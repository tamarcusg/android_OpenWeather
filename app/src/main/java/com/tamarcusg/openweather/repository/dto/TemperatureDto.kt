package com.tamarcusg.openweather.repository.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TemperatureDto(
    val temp: Double,
    @SerialName("feels_like")
    val feelsLike: Double
)