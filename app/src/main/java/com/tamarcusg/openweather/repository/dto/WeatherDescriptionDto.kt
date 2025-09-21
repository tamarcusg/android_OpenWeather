package com.tamarcusg.openweather.repository.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WeatherDescriptionDto(
    @SerialName("main")
    val description: String,
    @SerialName("description")
    val detailedDescription: String
)