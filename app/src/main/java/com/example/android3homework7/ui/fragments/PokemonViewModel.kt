package com.example.android3homework7.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android3homework7.data.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel
@Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)

}
