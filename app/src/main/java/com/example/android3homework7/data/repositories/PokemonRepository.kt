package com.example.android3homework7.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android3homework7.data.remote.apiservises.PokemonApiService
import com.example.android3homework7.data.repositories.pagingsources.PokemonPagingSource
import com.example.android3homework7.models.ResultsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonApiService,
) {

    fun fetchCharacters(): Flow<PagingData<ResultsItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                PokemonPagingSource(pokemonApiService)
            }).flow
    }
}