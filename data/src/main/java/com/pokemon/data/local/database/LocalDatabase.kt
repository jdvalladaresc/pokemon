package com.pokemon.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pokemon.data.local.dao.PokemonDao
import com.pokemon.data.local.tables.PokemonTable

@Database(
    entities = [PokemonTable::class],
    version = LocalDatabase.VERSION,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getPokemonDao(): PokemonDao
}