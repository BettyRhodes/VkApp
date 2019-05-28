package com.example.vkapi.presentation.screen.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.vkapi.R
import com.example.vkapi.presentation.common.BaseFragment
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.models.Profile
import com.example.vkapi.presentation.extensions.loadImage
import com.example.vkapi.presentation.models.BaseItem
import com.example.vkapi.presentation.screen.profile.adapter.FeedAdapter
import kotlinx.android.synthetic.main.fragment_profile_view.*
import javax.inject.Inject

class ProfileViewFragment: BaseFragment(R.layout.fragment_profile_view),
    ProfileView {

    override fun showNetworkError() {

    }

    override fun showProgress() {
        profileRefreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        profileRefreshLayout.isRefreshing = false
    }

    private val feedAdapter = FeedAdapter{presenter.loadPosts()}

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
    }

    private fun initFeed(){
        profileFeed.layoutManager = LinearLayoutManager(context)
        profileFeed.adapter = feedAdapter
    }

    override fun showProfile(profile: Profile) {
        avatar.loadImage(profile.avatar)
        profileCollapsingToolbarLayout.title = "${profile.firstName} ${profile.lastName}"
        feedAdapter.setProfile(profile)
    }

    override fun showFeed(items: List<PostMessage>) {
        feedAdapter.setItems(items)
    }

    private fun initToolbar(){
        profileToolbar.inflateMenu(R.menu.menu_profile_view)
        profileToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_profile_edit -> presenter.profileEdit()
                R.id.action_logout -> presenter.logout()
            }
            true
        }
    }
}