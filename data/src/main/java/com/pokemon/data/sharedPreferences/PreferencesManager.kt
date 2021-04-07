package com.pokemon.data.sharedPreferences

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(private val context: Context) {
    fun save(input: String?) {
        val editor = context.getSharedPreferences(
            KEY_,
            Context.MODE_PRIVATE
        ).edit()
        editor.putString(KEY_, input)
        editor.apply()
    }

    val lastAppointmentId: Int
        get() {
            val prefs = context.getSharedPreferences(
                KEY_,
                Context.MODE_PRIVATE
            )
            return prefs.getInt(KEY_, 0)
        }

    companion object {
        private const val KEY_ = "key_"
    }
}