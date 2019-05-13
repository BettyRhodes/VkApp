package com.example.vkapi.fragment.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkapi.App
import com.example.vkapi.fragment.profile.messages.CatMessage
import com.example.vkapi.fragment.profile.messages.PostMessage
import com.example.vkapi.navigation.Screen

@InjectViewState
class ProfileViewPresenter : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(
            "https://pp.userapi.com/c543105/v543105493/4df68/YGNqZ3NCgHI.jpg",
            "Юрий",
            "Пожидаев",
            "30 июня 1998",
            "Atlanta")

        viewState.showFeed((1..100).map{
            if(it % 5 == 0){
                CatMessage(
                    it,
                    "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
                )
            }else {
                PostMessage(
                    it,
                    "Message ".repeat(30),
                    "https://picsum.photos/id/$it/200/300"
                )
            }
        })
    }

    fun profileEdit(){
        App.INSTANCE.router.navigateTo(Screen.EditScreen())
    }

    fun logout(){
        App.INSTANCE.router.replaceScreen(Screen.LoginScreen())
    }
}