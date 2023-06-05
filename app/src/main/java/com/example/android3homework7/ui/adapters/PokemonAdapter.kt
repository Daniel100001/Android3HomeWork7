package com.example.android3homework7.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3homework7.databinding.ItemPokemonBinding
import com.example.android3homework7.models.PokemonModel

class PokemonAdapter :
    ListAdapter<PokemonModel, PokemonAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemonModel: PokemonModel) {
            val pokemonId =
                pokemonModel.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
                    .toInt()
            Glide.with(binding.itemPokemonImage.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonId.png")
                .into(binding.itemPokemonImage)
            binding.itemPokemonName.text = pokemonModel.name
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
        holder.onBind(getItem(position))
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<PokemonModel>() {

        override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem == newItem
        }
    }
}