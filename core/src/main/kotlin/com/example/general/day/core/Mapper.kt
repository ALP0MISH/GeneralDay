package com.example.general.day.core

interface Mapper<in From, out To> {
    fun map(from: From): To
}