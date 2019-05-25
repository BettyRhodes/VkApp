package com.example.vkapi.data.repository

import com.example.vkapi.data.converter.Converter
import com.example.vkapi.data.network.Api
import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.User
import com.example.vkapi.domain.repository.SessionRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val api: Api,
    private val userConverter: Converter<ProfileResponse, User>
) : SessionRepository{

    override fun login(email: String, password: String): Single<User> =
        api.login(email, password)
        .subscribeOn(Schedulers.io())
        .map(userConverter::convertTo)

    override fun isAuth(): Boolean = true
}