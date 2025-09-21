package com.tamarcusg.openweather.repository

import com.tamarcusg.openweather.repository.model.Forecast

internal class OpenWeatherRepositoryImpl(
    private val apiService: ApiService
) : OpenWeatherRepository {
    override suspend fun getCityForecast(cityName: String): ApiResult<List<Forecast>> {
        try {
            val result = apiService.getCityForecastData(cityName)
            return ApiResult.Success(result.toDomain())
        } catch (e: Exception) {
            return ApiResult.Error
        }
    }
}