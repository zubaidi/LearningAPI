package com.example.learningapi

import com.google.gson.annotations.SerializedName

data class GetDataAPI(

    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val judul: String?,
    @SerializedName("body")
    val text: String?

)
