package com.example.learningapi

import com.google.gson.annotations.SerializedName

data class PostDataAPI(
    @SerializedName("userId")
    val userID: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val judul: String?,
    @SerializedName("body")
    val text: String?
)
