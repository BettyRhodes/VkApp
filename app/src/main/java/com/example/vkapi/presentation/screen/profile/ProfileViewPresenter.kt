package com.example.vkapi.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkapi.App
import com.example.vkapi.presentation.entites.BasePresenter
import com.example.vkapi.presentation.entites.PostMessage
import com.example.vkapi.presentation.entites.Profile
import com.example.vkapi.presentation.navigation.Screen
import com.example.vkapi.presentation.screen.profile.ProfileView
import ru.terrakok.cicerone.Router

@InjectViewState
class ProfileViewPresenter(private val router: Router) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(
            Profile(
                1,
                "Юрий",
                "Пожидаев",
                "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg",
                "Атланта",
                "30 июня 1998",
                ""
            )
        )

        viewState.showFeed(
            listOf(
                PostMessage(
                    1,
                    "Юрий Пожидаев",
                    "Только сообщение",
                    "",
                    "",
                    "",
                    "",
                    "14 мая 2019",
                    10
                ), PostMessage(
                    4,
                    "Юрий Пожидаев",
                    "Классная песня",
                    "",
                    "",
                    "Murder On My Mind",
                    "YNW Melly",
                    "13 мая 2019",
                    17
                )
                , PostMessage(
                    2,
                    "Юрий Пожидаев",
                    "Пост с картинкой",
                    "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                    "",
                    "",
                    "",
                    "12 мая 2019",
                    23
                ), PostMessage(
                    4, "Юрий Пожидаев",
                    "Пост с видео",
                    "",
                    "Video",
                    "",
                    "",
                    "11 мая 2019",
                    32
                ), PostMessage(
                    5, "Юрий Пожидаев",
                    "Полный пост",
                    "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                    "Video",
                    "Murder On My Mind",
                    "YNW Melly",
                    "5 мая 2019",
                    21
                )
            )
        )
    }

    fun profileEdit() {
        router.navigateTo(Screen.EditScreen())
    }

    fun logout() {
        router.replaceScreen(Screen.LoginScreen())
    }
}