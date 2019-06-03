package com.example.vkapi.presentation.converter

interface PresentationConverter<T, K> {

    fun convertTo(t: T): K

}