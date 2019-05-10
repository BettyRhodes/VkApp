package com.example.vkapi.fragment.edit

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkapi.R
import com.example.vkapi.fragment.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import java.util.*
import kotlin.IllegalStateException

class EditProfileFragment: BaseFragment(R.layout.fragment_edit_profile), EditProfileView {

    @InjectPresenter
    lateinit var presenter: EditProfilePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initToolbar()

        editDate.setOnClickListener {
            openDatePickerDialog(it)
        }
    }

    override fun showEditError(message: Int) {
        Snackbar.make(
            view ?: throw IllegalStateException(),
            getString(message),
            Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun initToolbar(){
        editViewToolbar.inflateMenu(R.menu.menu_edit_view)
        editViewToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.saveChanges -> presenter.editProfile(editName.text.toString(), editSurname.text.toString())
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
                    R.id.editDate -> (v as EditText).setText(selectedDate)
                }
            }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
        datePickerDialog.show()
    }

}