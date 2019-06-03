package com.example.vkapi.data.datasource

import com.example.vkapi.dagger.MockQualifier
import com.example.vkapi.data.network.Api
import com.example.vkapi.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

interface AuthDataSource {
    fun login(email: String, password: String): Single<ProfileResponse>
}

class AuthDataSourceImpl @Inject constructor(@MockQualifier private val api: Api): AuthDataSource{
    override fun login(email: String, password: String): Single<ProfileResponse> =
            api.login(email, password)
}