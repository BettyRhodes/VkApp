package com.example.vkapi.presentation.screen.edit

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.vkapi.R
import com.example.vkapi.presentation.common.BaseFragment
import com.example.vkapi.presentation.models.Profile
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import java.util.*
import javax.inject.Inject
import kotlin.IllegalStateException

class EditProfileFragment : BaseFragment(R.layout.fragment_edit_profile),
    EditProfileView {

    @Inject
    @InjectPresenter
    lateinit var presenter: EditProfilePresenter

    @ProvidePresenter
    fun providePresenter(): EditProfilePresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initToolbar()

        profileEdit_Date.setOnClickListener {
            openDatePickerDialog(it)
        }
    }

    override fun showProfileInfo(profile: Profile) {
        profileEdit_Name.setText(profile.firstName)
        profileEdit_Surname.setText(profile.lastName)
        profileEdit_City.setText(profile.home)
        profileEdit_Status.setText(profile.status)
        profileEdit_Date.setText(profile.birthday)
    }

    override fun showEditError(message: Int) {
        Snackbar.make(
            view ?: throw IllegalStateException(),
            getString(message),
            Snackbar.LENGTH_SHORT
        )
            .show()
    }

    private fun initToolbar() {
        editViewToolbar.inflateMenu(R.menu.menu_edit_view)
        editViewToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.saveChanges -> {
                    val profile = Profile(
                    0,
                    profileEdit_Name.text.toString(),
                    profileEdit_Surname.text.toString(),
                    "https://pbs.twimg.com/profile_images/1129032835006812160/FyzA9DWR_400x400.jpg",
                    profileEdit_City.text.toString(),
                    profileEdit_Date.text.toString(),
                    profileEdit_Status.text.toString()
                    )
                    presenter.saveEdit(profile)
                }
            }
            true
        }
    }

    private fun openDatePickerDialog(v: View) {
        // Get Current Date
        val datePickerDialog = DatePickerDialog(
            activity ?: throw IllegalStateException(),
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth.${(monthOfYear + 1)}.$year"
                when (v.id) {
                    R.id.profileEdit_Date -> (v as EditText).setText(selectedDate)
                }
            },
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
        datePickerDialog.show()
    }

}