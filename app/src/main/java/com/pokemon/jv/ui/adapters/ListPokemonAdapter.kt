package com.pokemon.jv.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.databinding.ItemPokemonListBinding
import javax.inject.Inject

class ListPokemonAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ItemPokemonListBinding
    lateinit var context: Context
    lateinit var callback: ListPokemonCallback
    var list = ArrayList<Pokemon>()

    fun setListPokemonCallback(callback: ListPokemonCallback) {
        this.callback = callback
    }

    inner class ListPokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Pokemon, position: Int) {
            binding.tvName.text = model.name
            //https://pokeapi.co/api/v2/pokemon/19/
            if (model.url != null) {
                val imageUrl = model.url!!
                val idPokemon = imageUrl.substring(
                    imageUrl.substring(0, imageUrl.length - 1).lastIndexOf("/"),
                    imageUrl.length - 1
                )
                Glide.with(context)
                    .load("https://pokeres.bastionbot.org/images/pokemon/$idPokemon.png")
                    .into(binding.ivImage)
            }
            binding.root.setOnClickListener {
                callback.onClick(model, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ListPokemonViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ListPokemonViewHolder
        viewHolder.bind(list[position], position)
    }

    fun addItems(data: List<Pokemon>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ListPokemonCallback {
        fun onClick(model: Pokemon, position: Int)
    }
}