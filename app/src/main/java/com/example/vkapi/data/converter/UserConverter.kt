package com.example.vkapi.data.converter

import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.User
import javax.inject.Inject

class UserConverter @Inject constructor(): Converter<ProfileResponse, User> {
    override fun convertTo(t: ProfileResponse): User = User(
        t.id,
        t.firstName,
        t.lastName,
        t.avatar,
        t.home,
        t.birthday,
        t.status
    )
}