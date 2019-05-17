package com.example.vkapi.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).into(this)
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean): View =
    LayoutInflater.from(context)
        .inflate(layoutId, this, attachToRoot)

fun EditText.afterTextChanged(fieldStatus: () -> Unit){
    this.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            fieldStatus.invoke()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
}