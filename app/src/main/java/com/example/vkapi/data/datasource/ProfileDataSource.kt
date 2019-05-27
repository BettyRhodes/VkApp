package com.example.vkapi.data.datasource

import com.example.vkapi.dagger.MockQualifier
import com.example.vkapi.data.network.Api
import com.example.vkapi.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

interface ProfileDataSource {
    fun getProfile(): Single<ProfileResponse>
}

class ProfileDataSourceImpl @Inject constructor(@MockQualifier private val api: Api): ProfileDataSource{
    override fun getProfile(): Single<ProfileResponse> =
            Single.just(
                ProfileResponse(
                    1,
                    "Юрий",
                    "Пожидаев",
                    "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg",
                    "Атланта",
                    "30 июня 1998",
                    ""
                )
            )

}