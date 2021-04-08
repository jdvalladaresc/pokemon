package com.pokemon.domain.model

data class PokemonItem(
    var id: Int = 0,
    var abilities: ArrayList<AbilityItem>? = null,
    var moves: ArrayList<MoveItem>? = null,
    var type: ArrayList<TypeItem>? = null
)

data class AbilityItem(
    var name: String? = null,
    var url: String? = null
)

data class MoveItem(
    var name: String? = null,
    var url: String? = null
)

data class TypeItem(
    var slot: Int? = null,
    var name: String? = null,
    var url: String? = null
)