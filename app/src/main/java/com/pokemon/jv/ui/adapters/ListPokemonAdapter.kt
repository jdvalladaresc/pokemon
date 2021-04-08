package com.pokemon.jv.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pokemon.jv.R
import com.pokemon.jv.databinding.ItemPokemonListBinding
import com.pokemon.jv.model.PokemonModel
import javax.inject.Inject

class ListPokemonAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ItemPokemonListBinding
    lateinit var context: Context
    lateinit var callback: ListPokemonCallback
    var list = ArrayList<PokemonModel?>()

    fun setListPokemonCallback(callback: ListPokemonCallback) {
        this.callback = callback
    }

    inner class ListPokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: PokemonModel?, position: Int) {
            if (model != null) {
                binding.tvName.text = model.name?.capitalize()
                if (model.url != null) {
                    Glide.with(context)
                        .load("https://pokeres.bastionbot.org/images/pokemon/${model.id}.png")
                        .placeholder(R.drawable.ic_placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(false)
                        .into(binding.ivImage)
                }
                binding.root.setOnClickListener {
                    callback.onClick(model, position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding =
            ItemPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ListPokemonViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ListPokemonViewHolder) {
            holder.bind(list[position], position)
        }
    }

    fun addItems(data: ArrayList<PokemonModel?>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ListPokemonCallback {
        fun onClick(model: PokemonModel, position: Int)
    }
}