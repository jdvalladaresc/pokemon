package com.pokemon.data.entity.mapper

import com.pokemon.data.entity.NamedApiResource
import com.pokemon.data.entity.NamedApiResourceList
import com.pokemon.domain.model.PokemonListItem
import java.util.*

object PokemonListMapper {
    fun transform(response: NamedApiResourceList?): List<PokemonListItem>? {
        if (response == null) {
            return null
        }
        val list: MutableList<PokemonListItem> = ArrayList()
        for (item in response.results) {
            val data = transform(item)
            if (data != null)
                list.add(data)
        }
        return list
    }

    private fun transform(entity: NamedApiResource?): PokemonListItem? {
        if (entity == null) {
            return null
        }
        return PokemonListItem(entity.id, entity.name, entity.url)
    }
}
