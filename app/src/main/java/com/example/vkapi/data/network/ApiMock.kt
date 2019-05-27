package com.example.vkapi.data.network

import android.annotation.SuppressLint
import com.example.vkapi.data.response.Post
import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

class ApiMock @Inject constructor(): Api{

    @SuppressLint("CheckResult")
    override fun login(email: String, password: String): Single<ProfileResponse> =
        if(email == "123" && password == "1234"){
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
        }else{
            Single.error(RuntimeException("User not found"))
        }


    override fun getProfile(userId: Int): Single<ProfileResponse> =
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

    override fun getPosts(userId: Int): Single<PostResponse> =
        Single.just(
            PostResponse((1..10).map {
                listOf(
                    Post(
                        1,
                        "Юрий Пожидаев",
                        "Только сообщение",
                        "",
                        "",
                        "",
                        "",
                        "14 мая 2019",
                        10,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    ), Post(
                        4,
                        "Юрий Пожидаев",
                        "Классная песня",
                        "",
                        "",
                        "Murder On My Mind",
                        "YNW Melly",
                        "13 мая 2019",
                        17,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    )
                    , Post(
                        2,
                        "Юрий Пожидаев",
                        "Пост с картинкой",
                        "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                        "",
                        "",
                        "",
                        "12 мая 2019",
                        23,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    ), Post(
                        4, "Юрий Пожидаев",
                        "Пост с видео",
                        "",
                        "Video",
                        "",
                        "",
                        "11 мая 2019",
                        32,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    ), Post(
                        5, "Юрий Пожидаев",
                        "Полный пост",
                        "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                        "Video",
                        "Murder On My Mind",
                        "YNW Melly",
                        "5 мая 2019",
                        21,
                        "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg"
                    )
                )
            }.flatten()
        )
        )
}