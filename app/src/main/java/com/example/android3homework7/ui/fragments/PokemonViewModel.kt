package com.example.android3homework7.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3homework7.data.repositories.PokemonRepository
import com.example.android3homework7.models.PokemonModel
import com.example.android3homework7.models.PokemonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel
@Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    init {
        fetchCharacters()
    }

    private val _characterLiveData = MutableLiveData<PokemonResponse<PokemonModel>>()
    val characterLiveData: LiveData<PokemonResponse<PokemonModel>> get() = _characterLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

   private fun fetchCharacters(
    ) {
        repository.fetchCharacter(
            onResponse = { data ->
                _characterLiveData.value = data
            },
            onFailure = { message ->
                _errorLiveData.value = message
            }
        )
    }
}
