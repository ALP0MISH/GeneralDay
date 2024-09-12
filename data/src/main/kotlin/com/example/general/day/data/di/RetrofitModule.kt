package com.example.general.day.data.di

import com.example.general.day.data.BuildConfig
import com.example.general.day.data.cloud.service.CityWeatherService
import com.example.general.day.data.cloud.service.WeatherService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.OPEN_WEATHER_API)
            .addConverterFactory(GsonConverterFactory.create())

        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }
        builder.client(okHttpClientBuilder.build())
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Singleton
    @Provides
    fun provideCityService(retrofit: Retrofit): CityWeatherService =
        retrofit.create(CityWeatherService::class.java)
}
