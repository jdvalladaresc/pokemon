package com.pokemon.data.network

object Endpoints {
    const val URL_BASE = "https://pokeapi.co/api/v2/"

    const val POKEMON_LIST = "pokemon/"
    const val POKEMON_BY_ID = "pokemon/{id}/"
    const val POKEMON_ENCOUNTER_BY_ID = "pokemon/{id}/encounters/"
    const val POKEMON_EVOLUTION_CHAIN = "evolution-chain/{id}/"
}