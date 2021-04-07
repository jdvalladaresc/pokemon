package com.pokemon.data.entity.mapper

import com.pokemon.data.network.model.NamedApiResource
import com.pokemon.data.network.model.NamedApiResourceList
import com.pokemon.domain.model.Pokemon
import java.util.*

object ListPokemonMapper {

    fun transform(entity: NamedApiResourceList?): List<Pokemon>? {
        if (entity == null) {
            return null
        }
        val entities: MutableList<Pokemon> = ArrayList()
        for (newsEntity in entity.results) {
            val data = transform(newsEntity)
            if (data != null)
                entities.add(data)
        }
        return entities
    }

    private fun transform(entity: NamedApiResource?): Pokemon? {
        if (entity == null) {
            return null
        }
        return Pokemon(entity.name, entity.url)
    }
}
