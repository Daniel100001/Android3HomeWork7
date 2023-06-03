package com.example.android3homework7.data.remote.apiservises

import com.example.android3homework7.models.PokemonModel
import com.example.android3homework7.models.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon/")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonResponse<PokemonModel>

}