package com.example.general.day.data.modules

import com.example.general.day.data.service.WeatherService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://openweathermap.org/api"

@Module
class RetrofitModule {

    @Provides
    fun provideSignService(
        retrofit: Retrofit
    ): WeatherService = retrofit.create(WeatherService::class.java)

    @Provides
    fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            ).build()
    }
}