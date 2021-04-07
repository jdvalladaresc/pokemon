package com.pokemon.data.local.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
class PokemonTable {
    @PrimaryKey
    private var id = 0

    @ColumnInfo(name = "name")
    private var name: String? = null

    @ColumnInfo(name = "url")
    private var url: String? = null

    @ColumnInfo(name = "photo_url")
    private var photoUrl: String? = null
}