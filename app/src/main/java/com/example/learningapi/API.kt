package com.example.learningapi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface API {

    @GET("posts")
    fun getPost() : Call<ArrayList<DataAPI>>

}