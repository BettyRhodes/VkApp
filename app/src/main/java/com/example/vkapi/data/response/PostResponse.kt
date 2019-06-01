package com.example.vkapi.data.response

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("posts") val posts: List<Post>
)

class Post(
    @SerializedName("id") val id: Int,
    @SerializedName("profileName") val profileName: String,
    @SerializedName("message") val message: String,
    @SerializedName("image") val image: String,
    @SerializedName("video") val video: String,
    @SerializedName("musicName") val musicName: String,
    @SerializedName("musicAuthor") val musicAuthor: String,
    @SerializedName("date") val date: String,
    @SerializedName("likes") val likes: Int,
    @SerializedName("isLiked") val isLiked: Boolean,
    @SerializedName("avatar") val avatar: String
)