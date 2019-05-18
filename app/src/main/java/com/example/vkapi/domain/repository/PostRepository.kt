package com.example.vkapi.domain.repository

import com.example.vkapi.presentation.models.BaseItem

interface PostRepository {

    fun getAll(): List<BaseItem>
    fun getPost(id: Int): BaseItem
}