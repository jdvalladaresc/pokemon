package com.pokemon.data.entity.mapper

import com.pokemon.data.local.tables.PokemonTable
import com.pokemon.domain.model.Pokemon
import java.util.ArrayList

object PokemonTableDataMapper {
    fun transform(listEntities: List<PokemonTable>): List<Pokemon> {
        val list: MutableList<Pokemon> = ArrayList()
        for (entity in listEntities) {
            val data = transform(entity)
            if (data != null)
                list.add(data)
        }
        return list
    }

    private fun transform(entity: PokemonTable?): Pokemon? {
        if (entity == null) {
            return null
        }
        return Pokemon(entity.name, entity.url)
    }
}