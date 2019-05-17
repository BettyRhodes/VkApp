package com.example.vkapi.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkapi.R
import com.example.vkapi.entites.BaseItem
import com.example.vkapi.entites.PostMessage
import com.example.vkapi.entites.Profile
import com.example.vkapi.extensions.loadImage
import com.example.vkapi.fragment.BaseFragment
import com.example.vkapi.fragment.profile.adapter.FeedAdapter
import kotlinx.android.synthetic.main.fragment_profile_view.*

class ProfileViewFragment: BaseFragment(R.layout.fragment_profile_view), ProfileView {

    private val feedAdapter = FeedAdapter()

    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

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