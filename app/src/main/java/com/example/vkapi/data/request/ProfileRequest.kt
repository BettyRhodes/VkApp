package com.example.vkapi.data.request

import com.google.gson.annotations.SerializedName

class ProfileRequest(
    @SerializedName("id") val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("home") val home: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("status") val status: String
)