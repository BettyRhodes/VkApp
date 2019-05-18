package com.example.vkapi.presentation.entites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vkapi.presentation.moxy.MvpAppCompatFragment

abstract class BaseFragment(private val layoutId: Int): MvpAppCompatFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutId, container, false)
}