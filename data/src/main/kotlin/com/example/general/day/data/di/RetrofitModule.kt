package com.example.general.day.data.di

import com.example.general.day.data.cloud.service.CityWeatherService
import com.example.general.day.data.cloud.service.WeatherService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.openweathermap.org/"

@Module
class RetrofitModule {

    @Provides
    @DataScope
    fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()
    }

    @Provides
    @DataScope
    fun provideWeatherService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)

    @Provides
    @DataScope
    fun provideCityService(retrofit: Retrofit): CityWeatherService = retrofit.create(CityWeatherService::class.java)
}
