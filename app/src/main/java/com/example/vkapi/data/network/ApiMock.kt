package com.example.vkapi.data.network

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.example.vkapi.data.request.ProfileRequest
import com.example.vkapi.data.response.Post
import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.data.response.ProfileResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val FIRST_NAME = "first_name"
const val LAST_NAME = "last_name"
const val HOME_TOWN = "home_town"
const val BIRTH_DATE = "birth_date"
const val STATUS = "status"
const val AVATAR = "avatar"

class ApiMock @Inject constructor(private val sharedPreferences: SharedPreferences): Api{

    override fun saveEdit(userId: Int, profileRequest: ProfileRequest): Single<ProfileResponse> {
        sharedPreferences.edit()
            .putString(FIRST_NAME, profileRequest.firstName)
            .putString(LAST_NAME, profileRequest.lastName)
            .putString(AVATAR, profileRequest.avatar)
            .putString(HOME_TOWN, profileRequest.home)
            .putString(BIRTH_DATE, profileRequest.birthday)
            .putString(STATUS, profileRequest.status)
            .apply()

        return getProfile(userId)
    }

    @SuppressLint("CheckResult")
    override fun login(email: String, password: String): Single<ProfileResponse> =
        if(email == "123" && password == "1234"){
            if(!sharedPreferences.contains("first_name")){
                sharedPreferences.edit()
                    .putString(FIRST_NAME, "Юрий")
                    .putString(LAST_NAME, "Пожидаев")
                    .putString(AVATAR, "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg")
                    .putString(HOME_TOWN, "Атланта")
                    .putString(BIRTH_DATE, "30.06.1998")
                    .putString(STATUS, "")
                    .apply()
            }
            getProfile(3)
        }else{
            Single.error(RuntimeException("User not found"))
        }


    override fun getProfile(userId: Int): Single<ProfileResponse> =
        Single.just(
            ProfileResponse(
                userId,
                sharedPreferences.getString(FIRST_NAME, "").orEmpty(),
                sharedPreferences.getString(LAST_NAME, "").orEmpty(),
                "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg",
                sharedPreferences.getString(HOME_TOWN, "").orEmpty(),
                sharedPreferences.getString(BIRTH_DATE, "").orEmpty(),
                sharedPreferences.getString(STATUS, "").orEmpty()
            )
        )

    override fun getPosts(userId: Int, page: Int): Single<PostResponse> =
        Single.just(
            PostResponse((1..10).map {
                listOf(
                    Post(
                        1,
                        "${sharedPreferences.getString(FIRST_NAME, "").orEmpty()} ${sharedPreferences.getString(LAST_NAME, "").orEmpty()}",
                        "Только сообщение",
                        "",
                        "",
                        "",
                        "",
                        "14 мая 2019",
                        10,
                        false,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    ), Post(
                        4,
                        "${sharedPreferences.getString(FIRST_NAME, "").orEmpty()} ${sharedPreferences.getString(LAST_NAME, "").orEmpty()}",
                        "Классная песня",
                        "",
                        "",
                        "Murder On My Mind",
                        "YNW Melly",
                        "13 мая 2019",
                        17,
                        true,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    )
                    , Post(
                        2,
                        "${sharedPreferences.getString(FIRST_NAME, "").orEmpty()} ${sharedPreferences.getString(LAST_NAME, "").orEmpty()}",
                        "Пост с картинкой",
                        "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                        "",
                        "",
                        "",
                        "12 мая 2019",
                        23,
                        false,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    ), Post(
                        4,
                        "${sharedPreferences.getString(FIRST_NAME, "").orEmpty()} ${sharedPreferences.getString(LAST_NAME, "").orEmpty()}",
                        "Пост с видео",
                        "",
                        "Video",
                        "",
                        "",
                        "11 мая 2019",
                        32,
                        false,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    ), Post(
                        5,
                        "${sharedPreferences.getString(FIRST_NAME, "").orEmpty()} ${sharedPreferences.getString(LAST_NAME, "").orEmpty()}",
                        "Полный пост",
                        "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                        "Video",
                        "Murder On My Mind",
                        "YNW Melly",
                        "5 мая 2019",
                        21,
                        true,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    )
                )
            }.flatten()
        )
        ).delay(1, TimeUnit.SECONDS)

}