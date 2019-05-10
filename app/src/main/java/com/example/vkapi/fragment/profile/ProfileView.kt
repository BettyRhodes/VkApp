package com.example.vkapi.fragment.profile

import com.arellomobile.mvp.MvpView

interface ProfileView: MvpView {
    fun showProfile(image: String, firstName: String, lastName: String, birthday: String, city: String)
    fun showFeed(items: List<BaseMessage>)
}