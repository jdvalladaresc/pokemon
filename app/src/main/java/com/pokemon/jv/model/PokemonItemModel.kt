package com.pokemon.jv.model

data class PokemonItemModel(
    var id: Int = 0,
    var abilities: List<AbilityItemModel>? = null,
    var moves: List<MoveItemModel>? = null,
    var type: List<TypeItemModel>? = null
)

data class AbilityItemModel(
    var name: String? = null,
    var url: String? = null
)

data class MoveItemModel(
    var name: String? = null,
    var url: String? = null
)

data class TypeItemModel(
    var slot: Int? = null,
    var name: String? = null,
    var url: String? = null
)