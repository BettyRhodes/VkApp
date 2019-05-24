package com.example.vkapi.domain.repository

import com.example.vkapi.domain.entity.Profile
import io.reactivex.Single

interface SessionRepository {

    fun login(email: String, password: String): Single<Profile>
    fun isAuth(): Boolean
}