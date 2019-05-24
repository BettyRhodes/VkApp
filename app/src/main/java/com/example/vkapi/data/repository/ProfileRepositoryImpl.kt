package com.example.vkapi.data.repository

import com.example.vkapi.domain.entity.Profile
import com.example.vkapi.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(): ProfileRepository {

    override fun getProfile(): Profile {
       return Profile(
            1,
            "Юрий",
            "Пожидаев",
            "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg",
            "Атланта",
            "30 июня 1998",
            ""
        )
    }
}