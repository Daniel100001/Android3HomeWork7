package com.example.android3homework7.models

import com.google.gson.annotations.SerializedName

data class PokemonModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,

)