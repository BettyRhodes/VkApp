package com.example.vkapi.domain.entity

data class Profile(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val home: String,
    val birthday: String,
    val status: String
)