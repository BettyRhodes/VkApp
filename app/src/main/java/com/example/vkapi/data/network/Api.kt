package com.example.vkapi.data.network

import com.example.vkapi.data.response.ProfileResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("login")
    fun login(email: String, password: String): Single<ProfileResponse>

    @GET("{userId}/profile")
    fun getProfile(@Path("userId") userId: Int): Single<ProfileResponse>

    @GET("{userId}/posts")
    fun getPosts(@Path("userId") userId: Int): Single<ProfileResponse>
}