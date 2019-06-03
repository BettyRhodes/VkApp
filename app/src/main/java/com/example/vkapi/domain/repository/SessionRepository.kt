package com.example.vkapi.domain.repository

import com.example.vkapi.domain.entity.User
import io.reactivex.Single

interface SessionRepository {

    fun login(email: String, password: String): Single<User>
    fun isAuth(): Boolean
    fun logOut()
}