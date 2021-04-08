package com.pokemon.data.sharedPreferences

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(private val context: Context) {
    fun save(input: String?) {
        val editor = context.getSharedPreferences(
            PREFERENCES,
            Context.MODE_PRIVATE
        ).edit()
        editor.putString(KEY_USERNAME, input)
        editor.apply()
    }

    fun clear() {
        val editor = context.getSharedPreferences(
            PREFERENCES,
            Context.MODE_PRIVATE
        ).edit()
        editor.clear()
        editor.apply()
    }

    val getUsername: String?
        get() {
            val prefs = context.getSharedPreferences(
                PREFERENCES,
                Context.MODE_PRIVATE
            )
            return prefs.getString(KEY_USERNAME, "")
        }

    companion object {
        private const val PREFERENCES = "pokemon"
        private const val KEY_USERNAME = "key_username"
    }
}