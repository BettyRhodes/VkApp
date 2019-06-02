package com.example.vkapi.presentation.converter

interface TwoWayPresentationConverter<T, K> {

    fun convertTo(t: T): K
    fun convertFrom(k: K): T
}