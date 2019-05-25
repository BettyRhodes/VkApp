package com.example.vkapi.presentation.screen.profile

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.domain.repository.PostRepository
import com.example.vkapi.domain.repository.ProfileRepository
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val router: Router,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository
) : BasePresenter<ProfileView>() {

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(profileRepository.getProfile())

      //  postRepository.getPosts()
      //      .observeOn(AndroidSchedulers.mainThread())
      //      .subscribe(
      //          {
      //
      //          },
      //          {
//
      //          })
      //  viewState.showFeed(postRepository.getPosts())

    }

    fun profileEdit() {
        router.navigateTo(Screen.EditScreen())
    }

    fun logout() {
        router.replaceScreen(Screen.LoginScreen())
    }
}