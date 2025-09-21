package com.tamarcusg.openweather.repository

import com.tamarcusg.openweather.repository.model.CityForecast

internal interface OpenWeatherRepository {
    suspend fun getCityForecast(cityName: String): ApiResult<CityForecast>
}