package com.example.vkapi.data.converter

interface Converter<T, K> {
    fun convertTo(t: T): K
}