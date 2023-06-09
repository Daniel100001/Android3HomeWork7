package com.example.android3homework7.models

import com.google.gson.annotations.SerializedName

data class Info(

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: String,

    @SerializedName("results")
    val results: List<PokemonModel>
)