package com.pokemon.jv.internal.dagger.module

import android.content.Context
import com.pokemon.data.executor.JobExecutor
import com.pokemon.data.repository.UserDataRepository
import com.pokemon.data.repository.UserLocalDataRepository
import com.pokemon.data.sharedPreferences.PreferencesManager
import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import com.pokemon.domain.repository.UserRepository
import com.pokemon.domain.repository.UserLocalRepository
import com.pokemon.jv.AndroidApplication
import com.pokemon.jv.UIThread
import com.pokemon.jv.internal.bus.RxBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val mApplication: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return mApplication
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun provideUserLocalDataRepository(userLocalDataRepository: UserLocalDataRepository): UserLocalRepository {
        return userLocalDataRepository
    }

    @Provides
    @Singleton
    fun provideUserDataRepository(userDataRepository: UserDataRepository): UserRepository {
        return userDataRepository
    }

    @Provides
    @Singleton
    fun provideRxBus(): RxBus {
        return RxBus()
    }

    @Provides
    @Singleton
    fun providePreferenceManager(context: Context): PreferencesManager {
        return PreferencesManager(context)
    }
}