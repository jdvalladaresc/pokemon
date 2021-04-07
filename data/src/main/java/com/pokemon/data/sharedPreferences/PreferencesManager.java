package com.pokemon.data.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.content.Context.MODE_PRIVATE;

@Singleton
public class PreferencesManager {

    private static final String KEY_ = "key_";
    private final Context context;


    @Inject
    public PreferencesManager(Context context) {
        this.context = context;
    }

    public void save(String input) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY_, MODE_PRIVATE).edit();
        editor.putString(KEY_, input);
        editor.apply();
    }

    public int getLastAppointmentId() {
        SharedPreferences prefs = context.getSharedPreferences(KEY_, MODE_PRIVATE);
        return prefs.getInt(KEY_, 0);
    }

}
