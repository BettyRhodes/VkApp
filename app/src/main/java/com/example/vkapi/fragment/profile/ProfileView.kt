package com.example.vkapi.fragment.profile

import com.arellomobile.mvp.MvpView
import com.example.vkapi.entites.PostMessage
import com.example.vkapi.entites.Profile

interface ProfileView: MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<PostMessage>)
}