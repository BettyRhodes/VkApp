package com.example.vkapi.domain.repository

import com.example.vkapi.presentation.models.Profile

interface ProfileRepository {

    fun getProfile(): Profile
}