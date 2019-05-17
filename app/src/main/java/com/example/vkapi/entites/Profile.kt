package com.example.vkapi.entites

class Profile (id: Int,
               val firstName: String,
               val lastName: String,
               val avatar: String,
               val home: String,
               val birthday: String,
               val status: String): BaseItem(id)