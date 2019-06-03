package com.example.vkapi.data.datasource

import com.example.vkapi.dagger.MockQualifier
import com.example.vkapi.data.converter.UserRequestConverter
import com.example.vkapi.data.network.Api
import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.User
import io.reactivex.Single
import javax.inject.Inject

interface ProfileDataSource {
    fun getProfile(): Single<ProfileResponse>
    fun saveEdit(user: User): Single<ProfileResponse>
}

class ProfileDataSourceImpl @Inject constructor(
    @MockQualifier private val api: Api,
    private val userRequestConverter: UserRequestConverter
) : ProfileDataSource {

    override fun saveEdit(user: User): Single<ProfileResponse> =
        api.saveEdit(user.id, userRequestConverter.convertTo(user))

    override fun getProfile(): Single<ProfileResponse> =
        api.getProfile(1)
}