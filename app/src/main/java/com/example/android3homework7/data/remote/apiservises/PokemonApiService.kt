package com.example.android3homework7.data.remote.apiservises

import com.example.android3homework7.models.PokemonModel
import com.example.android3homework7.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon/")
     fun fetchCharacters(
    ): Call<PokemonResponse<PokemonModel>>

}