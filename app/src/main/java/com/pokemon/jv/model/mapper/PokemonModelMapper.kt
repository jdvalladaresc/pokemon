package com.pokemon.jv.model.mapper

import com.pokemon.domain.model.PokemonListItem
import com.pokemon.jv.model.PokemonModel
import java.util.*

object PokemonModelMapper {
    fun transform(entity: List<PokemonListItem>?): List<PokemonModel>? {
        if (entity == null) {
            return null
        }
        val list: MutableList<PokemonModel> = ArrayList()
        for (item in entity) {
            val data = transform(item)
            if (data != null)
                list.add(data)
        }
        return list
    }

    private fun transform(entity: PokemonListItem?): PokemonModel? {
        if (entity == null) {
            return null
        }
        val imageUrl = entity.url!!
        val idPokemon = imageUrl.substring(
            imageUrl.substring(0, imageUrl.length - 1).lastIndexOf("/") + 1,
            imageUrl.length - 1
        )
        return PokemonModel(idPokemon.toInt(), entity.name, entity.url)
    }
}