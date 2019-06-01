package com.example.vkapi.presentation.screen.profile

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.domain.entity.Post
import com.example.vkapi.domain.repository.PostRepository
import com.example.vkapi.domain.repository.ProfileRepository
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.common.Paginator
import com.example.vkapi.presentation.converter.PostMessageConverter
import com.example.vkapi.presentation.converter.ProfileConverter
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val router: Router,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository,
    private val profileConverter: ProfileConverter,
    private val postMessageConverter: PostMessageConverter
) : BasePresenter<ProfileView>() {

    private val paginator = Paginator(
        {
            postRepository.getPosts(it)
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
        },
        object : Paginator.ViewController<Post> {

            override fun showEmptyProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {

            }

            override fun showEmptyView(show: Boolean) {

            }

            override fun showData(show: Boolean, data: List<Post>) {
                viewState.showFeed(
                    data.map {postMessageConverter.convertTo(it) }
                )
            }

            override fun showErrorMessage(error: Throwable) {

            }

            override fun showRefreshProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showPageProgress(show: Boolean) {
                viewState.showProgress()
            }

        }
    )

    fun loadPosts() {
        paginator.loadNewPage()
    }

    fun refreshPosts() {
        paginator.refresh()
    }

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getProfile()
        paginator.refresh()
    }

    private fun getProfile() {
        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showProfile(profileConverter.convertTo(it))
                },
                {

                }
            ).untilDestroy()
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }

    fun profileEdit() {
        router.navigateTo(Screen.EditScreen())
    }

    fun logout() {
        router.replaceScreen(Screen.LoginScreen())
    }
}