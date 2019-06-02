package com.example.vkapi.data.network

import com.example.vkapi.data.request.ProfileRequest
import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.data.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.*

interface Api {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email: String, @Field("password") password: String): Single<ProfileResponse>

    @GET("{userId}/profile")
    fun getProfile(@Path("userId") userId: Int): Single<ProfileResponse>

    @GET("{userId}/posts")
    fun getPosts(@Path("userId") userId: Int, @Path("page") page: Int): Single<PostResponse>

    @POST("{userId}/profile")
    fun saveEdit(@Path("userId") userId: Int, @Body profileRequest: ProfileRequest): Single<ProfileResponse>
}