package com.pokemon.data.entity.mapper

import com.pokemon.data.entity.EvolutionChain
import com.pokemon.data.entity.LocationAreaEncounter
import com.pokemon.data.entity.Pokemon
import com.pokemon.domain.model.*

object PokemonItemMapper {
    fun transform(data: Pokemon): PokemonItem? {
        if (data == null) {
            return null
        }
        val result = PokemonItem()
        result.id = data.id
        val listAbilities = ArrayList<AbilityItem>()
        if (data.abilities.isNotEmpty()) {
            for (item in data.abilities) {
                val itemAbility = AbilityItem()
                itemAbility.name = item.ability.name
                itemAbility.url = item.ability.url
                listAbilities.add(itemAbility)
            }
            result.abilities = listAbilities
        }
        val listMoves = ArrayList<MoveItem>()
        if (data.moves.isNotEmpty()) {
            for (item in data.moves) {
                val itemMove = MoveItem()
                itemMove.name = item.move.name
                itemMove.url = item.move.url
                listMoves.add(itemMove)
            }
            result.moves = listMoves
        }
        val listType = ArrayList<TypeItem>()
        if (data.types.isNotEmpty()) {
            for (item in data.types) {
                val itemType = TypeItem()
                itemType.name = item.type.name
                itemType.slot = item.slot
                itemType.url = item.type.url
                listType.add(itemType)
            }
            result.type = listType
        }
        return result
    }

    fun transform(data: List<LocationAreaEncounter>): List<LocationAreaEncounterItem> {
        val result = ArrayList<LocationAreaEncounterItem>()
        for (item in data) {
            result.add(LocationAreaEncounterItem(item.locationArea.name))
        }
        return result
    }

    fun transform(data: EvolutionChain): List<EvolutionChainItem> {
        val result = ArrayList<EvolutionChainItem>()
        val evolves = data.chain.evolvesTo
        for (item in evolves) {
            result.add(EvolutionChainItem(item.species.name))
            if (item.evolvesTo.isNotEmpty()) {
                for (itemEvolves in item.evolvesTo) {
                    result.add(EvolutionChainItem(itemEvolves.species.name))
                }
            }
        }
        return result
    }
}