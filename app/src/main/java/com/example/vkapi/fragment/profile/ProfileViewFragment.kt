package com.example.vkapi.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkapi.R
import com.example.vkapi.common.loadImage
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
        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    override fun showProfile(image: String, firstName: String, lastName: String, birthday: String, city: String) {
        avatar.loadImage("https://pp.userapi.com/c543105/v543105493/4df68/YGNqZ3NCgHI.jpg")
        profileViewFirstName.text = firstName
        profileViewLastName.text = lastName
        profileBirthday.text = birthday
        profileCity.text = city
    }

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
    }

    private fun initToolbar(){
        profileViewToolbar.inflateMenu(R.menu.menu_profile_view)
        profileViewToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_profile_edit -> presenter.profileEdit()
                R.id.action_logout -> presenter.logout()
            }
            true
        }
    }
}