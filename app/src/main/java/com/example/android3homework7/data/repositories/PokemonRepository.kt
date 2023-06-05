package com.example.android3homework7.data.repositories

import com.example.android3homework7.data.remote.apiservises.PokemonApiService
import com.example.android3homework7.models.PokemonModel
import com.example.android3homework7.models.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonApiService,
) {

    fun fetchCharacter(
        onResponse: (data: PokemonResponse<PokemonModel>) -> Unit,
        onFailure: (errorMassage: String) -> Unit
    ) {
        pokemonApiService.fetchCharacters()
            .enqueue(object : Callback<PokemonResponse<PokemonModel>> {
                override fun onResponse(
                    call: Call<PokemonResponse<PokemonModel>>,
                    response: Response<PokemonResponse<PokemonModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        onResponse(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<PokemonResponse<PokemonModel>>, t: Throwable) {
                    onFailure(t.localizedMessage ?: "Error")
                }
            })
    }
}

