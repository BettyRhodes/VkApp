package com.example.vkapi.data.repository

import com.example.vkapi.data.converter.Converter
import com.example.vkapi.data.datasource.ProfileDataSource
import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.User
import com.example.vkapi.domain.repository.ProfileRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileDataSource,
    private val userConverter: Converter<ProfileResponse, User>
): ProfileRepository {

    override fun getProfile(): Single<User> =
            profileDataSource.getProfile()
                .subscribeOn(Schedulers.io())
                .map(userConverter::convertTo)
}