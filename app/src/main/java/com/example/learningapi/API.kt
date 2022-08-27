package com.example.learningapi

import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET("posts")
    fun getPost() : Call<ArrayList<GetDataAPI>>
    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userID: Int,
        @Field("title") judul: String,
        @Field("body") text: String,
    ) : Call<PostDataAPI>

}