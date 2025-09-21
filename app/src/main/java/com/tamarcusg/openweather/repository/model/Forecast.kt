package com.tamarcusg.openweather.repository.model

internal data class Forecast(
    val temperature: Double,
    val feelsLike: Double,
    val weatherDescriptions: List<WeatherDescription>
)