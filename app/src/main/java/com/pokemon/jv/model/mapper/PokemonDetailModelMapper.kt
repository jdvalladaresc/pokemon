package com.pokemon.jv.model.mapper

import com.pokemon.domain.model.*
import com.pokemon.jv.model.*

object PokemonDetailModelMapper {
    fun transform(data: PokemonItem): PokemonItemModel {
        val result = PokemonItemModel()
        result.id = data.id
        result.abilities = transformAbilities(data.abilities)
        result.moves = transformMoves(data.moves)
        result.type = transformType(data.type)
        return result
    }

    private fun transformType(type: ArrayList<TypeItem>?): List<TypeItemModel>? {
        if (type == null) {
            return null
        }
        val result = ArrayList<TypeItemModel>()
        for (item in type) {
            val data = TypeItemModel()
            data.url = item.url
            data.name = item.name
            result.add(data)
        }
        return result
    }

    private fun transformMoves(moves: ArrayList<MoveItem>?): List<MoveItemModel>? {
        if (moves == null) {
            return null
        }
        val result = ArrayList<MoveItemModel>()
        for (item in moves) {
            val data = MoveItemModel()
            data.url = item.url
            data.name = item.name
            result.add(data)
        }
        return result
    }

    private fun transformAbilities(abilities: ArrayList<AbilityItem>?): List<AbilityItemModel>? {
        if (abilities == null) {
            return null
        }
        val result = ArrayList<AbilityItemModel>()
        for (item in abilities) {
            val data = AbilityItemModel()
            data.url = item.url
            data.name = item.name
            result.add(data)
        }
        return result
    }

    fun transformAbilitiesDetail(abilities: List<AbilityItemModel>?): List<DetailModel>? {
        if (abilities == null) {
            return null
        }
        val result = ArrayList<DetailModel>()
        for (item in abilities) {
            result.add(DetailModel(item.name))
        }
        return result
    }

    fun transformMovesDetail(moves: List<MoveItemModel>?): List<DetailModel>? {
        if (moves == null) {
            return null
        }
        val result = ArrayList<DetailModel>()
        for (item in moves) {
            result.add(DetailModel(item.name))
        }
        return result
    }

    fun transformTypeDetail(types: List<TypeItemModel>?): List<DetailModel>? {
        if (types == null) {
            return null
        }
        val result = ArrayList<DetailModel>()
        for (item in types) {
            result.add(DetailModel(item.name))
        }
        return result
    }

    fun transformLocation(data: List<LocationAreaEncounterItem>): List<DetailModel>? {
        val result = ArrayList<DetailModel>()
        for (item in data) {
            result.add(DetailModel(item.name))
        }
        return result
    }

    fun transformEncountersDetail(data: List<DetailModel>?): List<DetailModel>? {
        if (data == null) {
            return null
        }
        val result = ArrayList<DetailModel>()
        for (item in data) {
            result.add(DetailModel(item.name))
        }
        return result
    }

    fun transformEvolutionChain(data: List<EvolutionChainItem>): List<DetailModel>? {
        val result = ArrayList<DetailModel>()
        for (item in data) {
            result.add(DetailModel(item.name))
        }
        return result
    }

    fun transformEvolutionDetail(data: List<DetailModel>?): List<DetailModel>? {
        if (data == null) {
            return null
        }
        val result = ArrayList<DetailModel>()
        for (item in data) {
            result.add(DetailModel(item.name))
        }
        return result
    }
}