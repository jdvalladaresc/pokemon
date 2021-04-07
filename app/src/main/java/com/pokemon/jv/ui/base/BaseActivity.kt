package com.pokemon.jv.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.pokemon.jv.AndroidApplication
import com.pokemon.jv.internal.dagger.component.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

    protected open fun getApplicationComponent(): ApplicationComponent? {
        return (application as AndroidApplication).getApplicationComponent()
    }
}