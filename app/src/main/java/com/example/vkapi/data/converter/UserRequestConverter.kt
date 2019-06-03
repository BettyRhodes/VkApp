package com.example.vkapi.data.converter

import com.example.vkapi.data.request.ProfileRequest
import com.example.vkapi.domain.entity.User
import javax.inject.Inject

class UserRequestConverter @Inject constructor(): Converter<User, ProfileRequest> {
    override fun convertTo(t: User): ProfileRequest = ProfileRequest(
        t.id,
        t.firstName,
        t.lastName,
        t.avatar,
        t.home,
        t.birthday,
        t.status
    )
}