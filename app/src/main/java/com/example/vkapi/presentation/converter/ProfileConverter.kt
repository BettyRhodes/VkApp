package com.example.vkapi.presentation.converter

import com.example.vkapi.domain.entity.User
import com.example.vkapi.presentation.models.Profile
import javax.inject.Inject

class ProfileConverter @Inject constructor() : TwoWayPresentationConverter<User, Profile> {

    override fun convertFrom(k: Profile): User =
        User(
            k.id,
            k.firstName,
            k.lastName,
            k.avatar,
            k.home,
            k.birthday,
            k.status
        )

    override fun convertTo(t: User): Profile =
        Profile(
            t.id,
            t.firstName,
            t.lastName,
            t.avatar,
            t.home,
            t.birthday,
            t.status
        )
}