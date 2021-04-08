package com.pokemon.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pokemon.data.local.tables.PokemonTable

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemons where id between :start and :end")
    fun getAllBetween(start: Int, end: Int): List<PokemonTable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<PokemonTable>)
}