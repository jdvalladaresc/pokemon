package com.pokemon.data.entity.mapper

import com.pokemon.data.entity.NamedApiResource
import com.pokemon.data.entity.NamedApiResourceList
import com.pokemon.domain.model.Pokemon
import java.util.*

object PokemonMapper {
    fun transform(response: NamedApiResourceList?): List<Pokemon>? {
        if (response == null) {
            return null
        }
        val list: MutableList<Pokemon> = ArrayList()
        for (item in response.results) {
            val data = transform(item)
            if (data != null)
                list.add(data)
        }
        return list
    }

    private fun transform(entity: NamedApiResource?): Pokemon? {
        if (entity == null) {
            return null
        }
        return Pokemon(entity.name, entity.url)
    }
}
