package com.example.android3homework7.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3homework7.databinding.ItemPokemonBinding
import com.example.android3homework7.models.ResultsItem

class PokemonAdapter :
    PagingDataAdapter<ResultsItem, PokemonAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(resultsItem: ResultsItem) {
            val pokemonId =
                resultsItem.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
                    .toInt()
            Glide.with(binding.itemPokemonImage.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonId.png")
                .into(binding.itemPokemonImage)
            binding.itemPokemonName.text = resultsItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        return ViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<ResultsItem>() {

        override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem == newItem
        }
    }
}