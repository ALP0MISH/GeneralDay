package com.example.general.day.domain.usecase

interface DeleteWeatherByIdUseCase {

    suspend operator fun invoke(id: String)
}