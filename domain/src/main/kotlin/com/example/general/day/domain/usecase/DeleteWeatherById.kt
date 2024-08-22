package com.example.general.day.domain.usecase

interface DeleteWeatherById {

    suspend operator fun invoke(id: String)
}