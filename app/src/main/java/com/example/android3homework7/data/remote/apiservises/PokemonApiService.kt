package com.example.android3homework7.data.remote.apiservises

import com.example.android3homework7.models.ResultsItem
import com.example.android3homework7.models.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon/")
   suspend fun fetchCharacters(
        @Query("page") page: Int
        ): PokemonResponse<ResultsItem>

}