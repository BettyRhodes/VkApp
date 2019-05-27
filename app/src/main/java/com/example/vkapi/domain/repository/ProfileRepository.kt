package com.example.vkapi.domain.repository

import com.example.vkapi.domain.entity.User
import io.reactivex.Single

interface ProfileRepository {

    fun getProfile(): Single<User>
}