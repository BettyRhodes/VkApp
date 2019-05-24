package com.example.vkapi.data.converter

import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.Profile
import javax.inject.Inject

class UserConverter @Inject constructor(): Converter<ProfileResponse, Profile> {
    override fun convertTo(t: ProfileResponse): Profile = Profile(
        t.id,
        t.firstName,
        t.lastName,
        t.avatar,
        t.home,
        t.birthday,
        t.status
    )

    override fun convertFrom(k: Profile): ProfileResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}