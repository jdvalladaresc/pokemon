package com.pokemon.jv.internal.dagger.module

import android.content.Context
import androidx.room.Room
import com.pokemon.data.local.database.Database
import com.pokemon.data.local.database.DatabaseImpl
import com.pokemon.data.local.database.LocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDatabaseModule {
    @Singleton
    @Provides
    fun providesLocalDatabase(context: Context): LocalDatabase {
        return Room.databaseBuilder(context, LocalDatabase::class.java, "pokemon-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesDatabase(localDatabase: LocalDatabase): Database {
        return DatabaseImpl(localDatabase)
    }
}
