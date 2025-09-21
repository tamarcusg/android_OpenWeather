package com.tamarcusg.openweather.repository.model

internal data class Forecast(
    val temperature: Int,
    val feelsLike: Int,
    val weatherDescriptions: List<WeatherDescription>
)