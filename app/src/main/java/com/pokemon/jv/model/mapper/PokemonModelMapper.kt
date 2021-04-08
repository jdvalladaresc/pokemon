package com.pokemon.jv.model.mapper

import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.model.PokemonModel
import java.util.*

object PokemonModelMapper {
    fun transform(entity: List<Pokemon>?): List<PokemonModel>? {
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

    private fun transform(entity: Pokemon?): PokemonModel? {
        if (entity == null) {
            return null
        }
        return PokemonModel(entity.name, entity.url)
    }
}