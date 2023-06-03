package com.example.android3homework7.models

import com.google.gson.annotations.SerializedName

data class ResultsItem(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("base_experience")
    var base_experience: Int,

    @SerializedName("height")
    var height: Int,

    @SerializedName("order")
    var order: Int,

    @SerializedName("weight")
    var weight: Int

)