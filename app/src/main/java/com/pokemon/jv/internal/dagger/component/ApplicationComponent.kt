package com.pokemon.jv.internal.dagger.component

import android.content.Context
import com.pokemon.data.sharedPreferences.PreferencesManager
import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import com.pokemon.domain.repository.UserLocalRepository
import com.pokemon.domain.repository.UserRepository
import com.pokemon.jv.internal.bus.RxBus
import com.pokemon.jv.internal.dagger.module.ApplicationModule
import com.pokemon.jv.internal.dagger.module.LocalDatabaseModule
import com.pokemon.jv.internal.dagger.module.NetworkModule
import com.pokemon.jv.ui.base.BaseActivity
import com.pokemon.jv.ui.base.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LocalDatabaseModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: BaseActivity)
    fun inject(fragment: BaseFragment)
    fun context(): Context
    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread(): PostExecutionThread
    fun rxBus(): RxBus
    fun userLocalRepository(): UserLocalRepository
    fun userRepository(): UserRepository
    fun preferenceManager(): PreferencesManager
}