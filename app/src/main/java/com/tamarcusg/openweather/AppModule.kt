package com.tamarcusg.openweather

import com.tamarcusg.openweather.home.HomeViewModel
import com.tamarcusg.openweather.repository.ApiService
import com.tamarcusg.openweather.repository.OpenWeatherRepository
import com.tamarcusg.openweather.repository.OpenWeatherRepositoryImpl
import com.tamarcusg.openweather.util.Constants.BASE_URL
import com.tamarcusg.openweather.util.Constants.NETWORK_CONTENT_TYPE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    internal fun provideJsonSerializer(): Json = Json { ignoreUnknownKeys = true }

    @Singleton
    @Provides
    internal fun provideRetrofit(
        json: Json
    ) = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory(MediaType.parse(NETWORK_CONTENT_TYPE)!!))
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    internal fun provideApiService(
        retrofit: Retrofit
    ) = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    internal fun provideOpenWeatherRepository(
        apiService: ApiService
    ): OpenWeatherRepository = OpenWeatherRepositoryImpl(apiService)

    @Singleton
    @Provides
    internal fun provideHomeViewModel(
        openWeatherRepository: OpenWeatherRepository
    ): HomeViewModel = HomeViewModel(openWeatherRepository)
}