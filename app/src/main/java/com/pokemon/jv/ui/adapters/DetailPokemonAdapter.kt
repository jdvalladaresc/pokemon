package com.pokemon.jv.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pokemon.jv.databinding.ItemTextBinding
import com.pokemon.jv.model.DetailModel
import javax.inject.Inject

class DetailPokemonAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: ItemTextBinding
    private var list = ArrayList<DetailModel>()

    inner class DetailPokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: DetailModel, position: Int) {
            binding.tvValue.text = model.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailPokemonViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DetailPokemonViewHolder) {
            holder.bind(list[position], position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun addItems(data: List<DetailModel>?) {
        if (data != null) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }
}