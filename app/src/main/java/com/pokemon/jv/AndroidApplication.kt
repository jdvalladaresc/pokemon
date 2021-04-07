package com.pokemon.jv

import android.app.Application
import com.pokemon.jv.internal.dagger.component.ApplicationComponent
import com.pokemon.jv.internal.dagger.component.DaggerApplicationComponent
import com.pokemon.jv.internal.dagger.module.ApplicationModule

class AndroidApplication : Application() {
    private lateinit var mApplicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}