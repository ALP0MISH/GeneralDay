package com.example.general.day.presentation.extention

interface Mapper<in From, out To> {
    fun map(from: From): To
}