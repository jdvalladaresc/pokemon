package com.pokemon.data.entity.mapper

import com.pokemon.data.local.tables.PokemonTable
import com.pokemon.domain.model.Pokemon
import kotlin.collections.ArrayList

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

    fun transformList(list: List<Pokemon>): List<PokemonTable> {
        val entities = ArrayList<PokemonTable>()
        for (item in list) {
            val data = PokemonTable()
            val imageUrl = item.url!!
            val idPokemon = imageUrl.substring(
                imageUrl.substring(0, imageUrl.length - 1).lastIndexOf("/") + 1,
                imageUrl.length - 1
            )
            data.id = idPokemon.toInt()
            data.name = item.name
            data.url = item.url
            entities.add(data)
        }
        return entities
    }
}