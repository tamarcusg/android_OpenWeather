package com.tamarcusg.openweather.repository

import com.tamarcusg.openweather.repository.model.Forecast


internal interface OpenWeatherRepository {
    suspend fun getCityForecast(cityName: String): ApiResult<List<Forecast>>
}