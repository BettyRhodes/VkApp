package com.example.vkapi.data.response

import com.google.gson.annotations.SerializedName

class ProfileResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("home") val home: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("status") val status: String
)