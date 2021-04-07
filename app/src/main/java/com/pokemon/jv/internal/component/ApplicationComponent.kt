package com.pokemon.jv.internal.component

import android.content.Context
import com.pokemon.data.sharedPreferences.PreferencesManager
import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import com.pokemon.domain.repository.UserRepository
import com.pokemon.jv.internal.dagger.module.ApplicationModule
import com.pokemon.jv.internal.dagger.module.LocalDatabaseModule
import com.pokemon.jv.internal.dagger.module.NetworkModule
import com.pokemon.jv.ui.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LocalDatabaseModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: BaseActivity?)
    fun context(): Context?
    fun threadExecutor(): ThreadExecutor?
    fun postExecutionThread(): PostExecutionThread?

    //RxBus rxBus();
    fun userRepository(): UserRepository
    fun preferenceManager(): PreferencesManager?
}